package ca.yuey.thebudget.data;

import android.content.Context;

/**
 * Created by Yuey on 2015-01-04.
 */
public class AppState
{
	private static AppState instance = null;

	private Context ctx;

	public static void initState( Context context )
	{
		if ( instance == null )
		{
			instance = new AppState(context);
		}
	}

	public static AppState getAppState()
	{
		if ( instance == null )
		{
			throw new IllegalStateException(
					"ca.yuey.thebudget.data.AppState has not been initialized (did you forget to call initState?)" );
		}
		return instance;
	}

	private AppState(Context ctx)
	{
		this.ctx = ctx;
	}
}
