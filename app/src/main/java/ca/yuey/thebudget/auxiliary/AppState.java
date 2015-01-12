package ca.yuey.thebudget.auxiliary;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import ca.yuey.thebudget.data.Semester;

/**
 * Created by Yuey on 2015-01-04.
 */
public class AppState
		implements FileManager.SaveFinishListener, FileManager.LoadFinishListener
{
	public static final String PREFS_KEY_DEFAULT   = "default";
	public static final String KEY_FIRST_TIME_INIT = "firstTimeInit";

	public static final String DEFAULT_SEMESTER_FILENAME = "semester";
	public static final String FILE_EXT                  = ".sav";

	private static AppState instance = null;

	private Context     ctx;
	private Semester    currentSemester;
	private FileManager fileManager;

	private AppState( Context ctx )
	{
		this.ctx = ctx;
		this.fileManager = new FileManager( ctx );
	}

	public static void initState( Context context )
	{
		if ( instance == null )
		{
			instance = new AppState( context );
			instance.init();
		}
	}

	private void init()
	{
		SharedPreferences prefs = ctx.getSharedPreferences( PREFS_KEY_DEFAULT,
															Context.MODE_PRIVATE );

		if ( !prefs.contains( KEY_FIRST_TIME_INIT ) ) firstTimeInit();

		currentSemester = (Semester) fileManager.loadObject(
				DEFAULT_SEMESTER_FILENAME + FILE_EXT );
	}

	private void firstTimeInit()
	{
		SharedPreferences.Editor editor = ctx.getSharedPreferences(
				PREFS_KEY_DEFAULT,
				Context.MODE_PRIVATE ).edit();
		editor.putBoolean( KEY_FIRST_TIME_INIT, true );
		editor.apply();

		fileManager.saveObject( new Semester(),
								DEFAULT_SEMESTER_FILENAME + FILE_EXT );
	}

	public static AppState getAppState()
	{
		if ( instance == null )
		{
			throw new IllegalStateException(
					"ca.yuey.thebudget.auxiliary.AppState was retrieved but not initialized (initState not called)" );
		}
		return instance;
	}

	@Override
	public void onLoadFail( String tag, Exception e )
	{

	}

	@Override
	public void onLoadSuccess( String tag, Object o )
	{

	}

	@Override
	public void onSaveFail( String tag, Exception e )
	{
		Log.e( "ca.yuey.thebudget.auxiliary.AppState#onSaveFail", "Saving \"" + tag + "\" failed: " + e.getMessage() );
	}

	@Override
	public void onSaveSuccess( String tag )
	{
		Log.v( "ca.yuey.thebudget.auxiliary.AppState#onSaveFail", "Saving \"" + tag + "\" successful.");
	}

	public Semester getCurrentSemester()
	{
		return currentSemester;
	}

	public void commitSemester()
	{
		fileManager.saveObjectCocurrent( currentSemester,
										 DEFAULT_SEMESTER_FILENAME + FILE_EXT,
										 this );
	}
}
