package ca.yuey.thebudget.application.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ca.yuey.thebudget.R;
import ca.yuey.thebudget.data.Semester;

/**
 * Created by Yuey on 03/01/2015.
 */
public class SemesterFragment
		extends Fragment
{
	public static SemesterFragment newInstance( Semester semester )
	{
		SemesterFragment result = new SemesterFragment();
		return result;
	}

	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState )
	{
		View resultView = inflater.inflate( R.layout.fragment_semester,
											container,
											false );
		return resultView;
	}
}
