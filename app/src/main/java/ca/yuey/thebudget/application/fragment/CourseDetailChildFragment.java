package ca.yuey.thebudget.application.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ca.yuey.thebudget.R;


public class CourseDetailChildFragment
		extends BaseChildFragment
{
	public CourseDetailChildFragment()
	{
		// Required empty public constructor
	}

	public static CourseDetailChildFragment newInstance()
	{
		CourseDetailChildFragment fragment = new CourseDetailChildFragment();
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
		return inflater.inflate( R.layout.fragment_child_course_detail,
								 container,
								 false );
	}

	@Override
	public void onDetach()
	{
		super.onDetach();
	}
}
