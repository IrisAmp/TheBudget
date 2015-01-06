package ca.yuey.thebudget.application.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import ca.yuey.thebudget.R;
import ca.yuey.thebudget.application.adapter.CourseContentArrayAdapter;
import ca.yuey.thebudget.data.Gradable;

public class CourseContentChildFragment
		extends BaseChildFragment
{
	private Context ctx;

	private ListView         itemsListView;
	private List< Gradable > data;

	public CourseContentChildFragment()
	{
		// Required empty public constructor
	}

	public static CourseContentChildFragment newInstance( List< Gradable > content )
	{
		CourseContentChildFragment fragment = new CourseContentChildFragment();
		fragment.data = content;
		return fragment;
	}

	@Override
	public void onAttach( Activity activity )
	{
		super.onAttach( activity );
		this.ctx = activity;
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

		itemsListView = (ListView) v.findViewById( R.id.fragment_courseContent_listView );
		setupListView();

		return v;
	}

	private void setupListView()
	{
		CourseContentArrayAdapter adapter = new CourseContentArrayAdapter( ctx, data );
		itemsListView.setAdapter( adapter );
	}

	@Override
	public void onDetach()
	{
		super.onDetach();
		this.ctx = null;
	}
}
