package ca.yuey.thebudget.Model;

import android.content.Context;

/**
 * Created by Yuey on 2015-01-04.
 */
public class AppState
{
    private static AppState instance = null;

    private Context ctx;

    public static void initState(Context context)
    {
        if (instance == null)
        {

        }
    }

    public static AppState getAppState()
    {
        if (instance == null) throw new IllegalStateException();
        return instance;
    }
}
