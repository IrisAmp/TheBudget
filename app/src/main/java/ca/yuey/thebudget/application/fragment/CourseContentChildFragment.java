package ca.yuey.thebudget.application.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

import ca.yuey.thebudget.R;
import ca.yuey.thebudget.application.adapter.CourseContentArrayAdapter;
import ca.yuey.thebudget.data.Gradable;

public class CourseContentChildFragment
		extends BaseChildFragment
{
	private Activity activity;

	private FrameLayout           currentItem;
	private ArrayList< Gradable > data;

	public CourseContentChildFragment()
	{
		// Required empty public constructor
	}

	public static CourseContentChildFragment newInstance( ArrayList< Gradable > content )
	{
		CourseContentChildFragment fragment = new CourseContentChildFragment();
		fragment.data = content;
		return fragment;
	}

	@Override
	public void onAttach( Activity activity )
	{
		super.onAttach( activity );
		this.activity = activity;
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
		View v = inflater.inflate( R.layout.fragment_child_course_content,
								   container,
								   false );

		currentItem = (FrameLayout) v.findViewById( R.id.fragment_courseContent_frame );
		CourseContentArrayAdapter adapter = new CourseContentArrayAdapter(
				activity,
				data );

		replaceFrameView( adapter.getView( 0, null, null ) );

		return v;
	}

	private void replaceFrameView( View v )
	{
		currentItem.removeAllViews();
		currentItem.addView( v );
	}

	@Override
	public void onDetach()
	{
		super.onDetach();
		this.activity = null;
	}
}
