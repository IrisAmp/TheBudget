package ca.yuey.thebudget.Auxiliary;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Yuey on 2015-01-05.
 */
public class FileManager
{
    Context appContext;
    Uri filePath;

    public FileManager( Context ctx )
    {
        appContext = ctx.getApplicationContext();
        filePath = Uri.fromFile( ctx.getFilesDir() );
    }

    public void saveObject(Serializable saveMe, String filename)
    {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try
        {
            fos = new FileOutputStream( filePath.getPath() + filename );
            oos = new ObjectOutputStream( fos );

            oos.writeObject( saveMe );

            oos.close();
            fos.close();
        }
        catch (Exception e)
        {
            handleError( e );
        }
    }

    public Object loadObject(String filename)
    {
        Object result = null;

        FileInputStream fis;
        ObjectInputStream ois;

        try
        {
            fis = new FileInputStream( filePath.getPath() + filename );
            ois = new ObjectInputStream( fis );

            result =  ois.readObject();

            ois.close();
            fis.close();
        }
        catch (Exception e)
        {
            handleError( e );
        }

        return result;
    }

    private void handleError(Exception e)
    {
        Log.e( "ca.yuey.thebudget.Auxiliary.FileManager.handleError", "File IO failed: " + e.getMessage() );
    }
}
