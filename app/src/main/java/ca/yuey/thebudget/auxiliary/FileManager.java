package ca.yuey.thebudget.auxiliary;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 * Created by Yuey on 2015-01-05.
 */
public class FileManager
{
	private Context appContext;
	private Uri     filePath;
	private Map< String, Semaphore > locks = Collections.synchronizedMap( new HashMap< String, Semaphore >() );

	public FileManager( Context ctx )
	{
		appContext = ctx.getApplicationContext();
		filePath = Uri.fromFile( ctx.getFilesDir() );
	}

	public void saveObject( Object saveMe, String filename )
	{
		FileOutputStream fos;
		ObjectOutputStream oos;

		try
		{
			fos = new FileOutputStream( filePath.getPath() + filename );
			oos = new ObjectOutputStream( fos );

			oos.writeObject( saveMe );

			oos.close();
			fos.close();
		}
		catch ( Exception e )
		{
			handleError( e );
		}
	}

	private void handleError( Exception e )
	{
		Log.e( "ca.yuey.thebudget.FileManager.handleError",
			   "File IO failed: " + e.getMessage() );
	}

	public Object loadObject( String filename )
	{
		Object result = null;

		FileInputStream fis;
		ObjectInputStream ois;

		try
		{
			fis = new FileInputStream( filePath.getPath() + filename );
			ois = new ObjectInputStream( fis );

			result = ois.readObject();

			ois.close();
			fis.close();
		}
		catch ( Exception e )
		{
			handleError( e );
		}

		return result;
	}

	public void saveObjectCocurrent( Object saveMe, String filename, SaveFinishListener callbackTarget )
	{
		new AsyncSave( filename, callbackTarget ).execute( saveMe );
	}

	public void loadObjectCocurrent( String filename, LoadFinishListener callbackTarget )
	{
		new AsyncLoad( filename, callbackTarget ).execute();
	}

	private void acquireSemaphore( String key )
			throws InterruptedException
	{
		if ( !locks.containsKey( key ) )
		{
			Log.i( "ca.yuey.thebudget.auxiliary.FileManager#acquireSemaphore",
				   "Creating MUTEX for key \"" + key + "\"" );
			locks.put( key, new Semaphore( 1, true ) );
		}

		Log.i( "ca.yuey.thebudget.auxiliary.FileManager#acquireSemaphore",
			   "Acquiring MUTEX for key \"" + key + "\"" );

		Semaphore lock = locks.get( key );
		lock.acquire();
	}

	private void releaseSemaphore( String key )
	{
		Log.i( "ca.yuey.thebudget.auxiliary.FileManager#releaseSemaphore",
			   "Releasing MUTEX for key \"" + key + "\"" );
		Semaphore lock = locks.get( key );
		lock.release();
		if ( lock.availablePermits() > 1 )
		{
			Log.w( "ca.yuey.thebudget.auxiliary.FileManager#releaseSemaphore",
				   "MUTEX for key \"" + key + "\" has " + String.valueOf( lock.availablePermits() ) + " permits." );
		}
	}

	public interface SaveFinishListener
	{
		public abstract void onSaveFail( String tag, Exception e );

		public abstract void onSaveSuccess( String tag );
	}

	public interface LoadFinishListener
	{
		public abstract void onLoadFail( String tag, Exception e );

		public abstract void onLoadSuccess( String tag, Object o );
	}

	private class AsyncSave
			extends AsyncTask< Object, Exception, Void >
	{
		private final String             target;
		private final SaveFinishListener callbackTarget;

		public AsyncSave( String filename, SaveFinishListener callbackTarget )
		{
			this.target = filename;
			this.callbackTarget = callbackTarget;
		}

		@Override
		protected Void doInBackground( Object... params )
		{
			try
			{
				acquireSemaphore( target );
			}
			catch ( InterruptedException e )
			{
				publishProgress( new IOException( "AsyncSave failed: " + e.getMessage() ) );
				return null;
			}

			FileOutputStream fos;
			ObjectOutputStream oos;

			try
			{
				fos = new FileOutputStream( filePath.getPath() + target );
				oos = new ObjectOutputStream( fos );

				oos.writeObject( params[ 0 ] );

				oos.close();
				fos.close();
			}
			catch ( Exception e )
			{
				publishProgress( new IOException( "AsyncSave failed: " + e.getMessage() ) );
			}
			finally
			{
				releaseSemaphore( target );
			}

			return null;
		}

		@Override
		protected void onProgressUpdate( Exception... values )
		{
			for ( Exception e : values )
				callbackTarget.onSaveFail( target, e );
		}

		@Override
		protected void onPostExecute( Void aVoid )
		{
			callbackTarget.onSaveSuccess( target );
		}
	}

	private class AsyncLoad
			extends AsyncTask< Void, Exception, Object >
	{
		private final String             target;
		private final LoadFinishListener callbackTarget;

		public AsyncLoad( String filename, LoadFinishListener callbackTarget )
		{
			this.target = filename;
			this.callbackTarget = callbackTarget;
		}

		@Override
		protected Object doInBackground( Void... params )
		{
			try
			{
				acquireSemaphore( target );
			}
			catch ( InterruptedException e )
			{
				publishProgress( new IOException( "AsyncSave failed: " + e.getMessage() ) );
				return null;
			}

			FileInputStream fis;
			ObjectInputStream ois;

			Object result = null;

			try
			{
				fis = new FileInputStream( filePath.getPath() + target );
				ois = new ObjectInputStream( fis );

				result = ois.readObject();

				ois.close();
				fis.close();
			}
			catch ( Exception e )
			{
				publishProgress( new IOException( "AsyncSave failed: " + e.getMessage() ) );
			}
			finally
			{
				releaseSemaphore( target );
			}

			return result;
		}

		@Override
		protected void onProgressUpdate( Exception... values )
		{
			for ( Exception e : values )
				callbackTarget.onLoadFail( target, e );
		}

		@Override
		protected void onPostExecute( Object o )
		{
			callbackTarget.onLoadSuccess( target, o );
		}
	}
}
