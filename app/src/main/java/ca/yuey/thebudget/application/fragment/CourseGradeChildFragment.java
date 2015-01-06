package ca.yuey.thebudget.application.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ca.yuey.thebudget.R;

public class CourseGradeChildFragment
		extends BaseChildFragment
{
	public CourseGradeChildFragment()
	{
		// Required empty public constructor
	}

	public static CourseGradeChildFragment newInstance()
	{
		CourseGradeChildFragment fragment = new CourseGradeChildFragment();
		return fragment;
	}

	@Override
	public void onAttach( Activity activity )
	{
		super.onAttach( activity );
	}

	@Override
	public void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
	}

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
	{
		// Inflate the layout for this fragment
		return inflater.inflate( R.layout.fragment_child_course_grade,
								 container,
								 false );
	}

	@Override
	public void onDetach()
	{
		super.onDetach();
	}


}
