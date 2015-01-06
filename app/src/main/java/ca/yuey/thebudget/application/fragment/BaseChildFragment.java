package ca.yuey.thebudget.application.fragment;

import android.support.v4.app.Fragment;

import java.lang.reflect.Field;

/**
 * Created by Yuey on 05/01/2015.
 */
public class BaseChildFragment
		extends Fragment
{
	@Override
	public void onDetach()
	{
		super.onDetach();
		/*
		try
		{
			Field childFragmentManager = Fragment.class.getDeclaredField(
					"mChildFragmentManager" );
			childFragmentManager.setAccessible( true );
			childFragmentManager.set( this, null );

		}
		catch ( NoSuchFieldException e )
		{
			throw new RuntimeException( e );
		}
		catch ( IllegalAccessException e )
		{
			throw new RuntimeException( e );

		}//*/
	}
}
