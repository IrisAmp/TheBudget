package ca.yuey.thebudget.application.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import ca.yuey.thebudget.R;
import ca.yuey.thebudget.data.Course;

/**
 * Created by Yuey on 03/01/2015.
 */

public class CourseFragment
	    extends Fragment
{
	private Course course;

	private EditText    titleEditText;
	private EditText    creditsEditText;
	private Button      detailsButton;
	private Button      contentButton;
	private Button      gradesButton;
	private FrameLayout frameLayout;

    private int currentTab;

	public static CourseFragment newInstance( Course course )
	{
		CourseFragment result = new CourseFragment();
		result.course = course;
		return result;
	}

	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState )
	{
		View resultView = inflater.inflate( R.layout.fragment_course,
											container,
											false );

		getLayoutHandles( resultView );
		setupButtons();
        initFrame();

		return resultView;
	}

    private void initFrame()
    {
        getChildFragmentManager()
            .beginTransaction()
            .add( R.id.fragment_course_frame,
                  CourseDetailChildFragment.newInstance() )
            .commit();
        currentTab = R.layout.fragment_child_course_detail;
    }

    private void getLayoutHandles( View v )
	{
		titleEditText = (EditText) v.findViewById( R.id.fragment_course_title );
		creditsEditText = (EditText) v.findViewById( R.id.fragment_course_credits );
		detailsButton = (Button) v.findViewById( R.id.fragment_course_detailsButton );
		contentButton = (Button) v.findViewById( R.id.fragment_course_contentButton );
		gradesButton = (Button) v.findViewById( R.id.fragment_course_gradesButton );
		frameLayout = (FrameLayout) v.findViewById( R.id.fragment_course_frame );
	}

	private void setupButtons()
	{
		detailsButton.setOnClickListener( new View.OnClickListener()
		{
			@Override
			public void onClick( View v )
			{
				setFrameView( R.layout.fragment_child_course_detail );
			}
		} );

		contentButton.setOnClickListener( new View.OnClickListener()
		{
			@Override
			public void onClick( View v )
			{
				setFrameView( R.layout.fragment_child_course_content );
			}
		} );

		gradesButton.setOnClickListener( new View.OnClickListener()
		{
			@Override
			public void onClick( View v )
			{
				setFrameView( R.layout.fragment_child_course_grade );
			}
		} );
	}

	private void setFrameView( int id )
	{
		Fragment fragment = null;

		switch ( id )
		{
		case R.layout.fragment_child_course_detail:
            if (currentTab == R.layout.fragment_child_course_detail) return;
            fragment = CourseDetailChildFragment.newInstance();
            currentTab = R.layout.fragment_child_course_detail;
			break;

		case R.layout.fragment_child_course_content:
            if (currentTab == R.layout.fragment_child_course_content) return;
            fragment = CourseContentChildFragment.newInstance(course.getContent());
            currentTab = R.layout.fragment_child_course_content;
			break;

		case R.layout.fragment_child_course_grade:
            if (currentTab == R.layout.fragment_child_course_grade ) return;
			fragment = CourseGradeChildFragment.newInstance();
            currentTab = R.layout.fragment_child_course_grade;
			break;

		default:
			return;
		}

		getChildFragmentManager().beginTransaction()
								 .replace( R.id.fragment_course_frame, fragment )
								 .commit();
	}
}
