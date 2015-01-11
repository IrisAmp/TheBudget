package ca.yuey.thebudget.application.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.ToggleButton;

import ca.yuey.thebudget.R;
import ca.yuey.thebudget.application.adapter.SimpleCourseContentArrayAdapter;
import ca.yuey.thebudget.data.Course;


public class CourseDetailChildFragment
		extends BaseChildFragment
{
	public static final String ARG_COURSE = "course";

	private Course data;

	private EditText     descriptionEditText;
	private ToggleButton passFailButton;
	private Spinner      targetGradeSpinner;
	private Spinner      prioritySpinner;
	private LinearLayout contentPreviewListView;

	public CourseDetailChildFragment()
	{
		// Required empty public constructor
	}

	public static CourseDetailChildFragment newInstance( Course data )
	{
		CourseDetailChildFragment fragment = new CourseDetailChildFragment();

		Bundle args = new Bundle();
		args.putSerializable( ARG_COURSE, data );
		fragment.setArguments( args );

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
		if ( getArguments() != null )
		{
			this.data = (Course) getArguments().getSerializable( ARG_COURSE );
		}
	}

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
	{
		View v = inflater.inflate( R.layout.fragment_child_course_detail,
								   container,
								   false );

		getLayoutHandles( v );
		populatePreviewList();

		return v;
	}

	private void getLayoutHandles( View v )
	{
		descriptionEditText = (EditText) v.findViewById( R.id.fragment_courseDetail_description );
		passFailButton = (ToggleButton) v.findViewById( R.id.fragment_courseDetail_passFailButton );
		targetGradeSpinner = (Spinner) v.findViewById( R.id.fragment_courseDetail_targetGradeSpinner );
		prioritySpinner = (Spinner) v.findViewById( R.id.fragment_courseDetail_prioritySpinner );
		contentPreviewListView = (LinearLayout) v.findViewById( R.id.fragment_courseDetail_itemsPreviewLinearLayout );
	}

	private void populatePreviewList()
	{
		SimpleCourseContentArrayAdapter adapter = new SimpleCourseContentArrayAdapter(
				getActivity(),
				R.layout.listitem_simplecoursecontent,
				R.id.listitem_simpleCourseContent_title,
				data.getContent() );

		final int countItems = adapter.getCount();

		for ( int i = 0; i < countItems; i++ )
		{
			View v = adapter.getView( i, null, null );
			contentPreviewListView.addView( v );
		}
	}
}
