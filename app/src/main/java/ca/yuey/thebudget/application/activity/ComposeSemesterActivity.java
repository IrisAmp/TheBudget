package ca.yuey.thebudget.application.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import ca.yuey.thebudget.R;
import ca.yuey.thebudget.application.fragment.CourseFragment;
import ca.yuey.thebudget.application.fragment.SemesterFragment;
import ca.yuey.thebudget.data.Course;
import ca.yuey.thebudget.data.Semester;

public class ComposeSemesterActivity
		extends FragmentActivity
{
	public static final String ARG_SEMESTER = "composeSemesterActivity_semester";

	private PagerAdapter adapter;
	private ViewPager    pager;

	private Semester            semester = null;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_compose_semester );

		getArgs( savedInstanceState );
		getLayoutHandles();
		initPager();
	}

	private void getLayoutHandles()
	{
		pager = (ViewPager) findViewById( R.id.composeSemester_viewPager );
	}

	private void initPager()
	{
		adapter = new PagerAdapter( getSupportFragmentManager(), semester );
		pager.setAdapter( adapter );
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		getMenuInflater().inflate( R.menu.menu_compose_semester, menu );
		return true;
	}

	private void getArgs( Bundle bundle )
	{
		Semester s = null;

		if ( bundle != null )
		{
			s = (Semester) bundle.get( ARG_SEMESTER );
		}

		if ( s != null ) this.semester = s;
		else this.semester = new Semester();
	}

	@Override
	public boolean onOptionsItemSelected( MenuItem item )
	{
		switch ( item.getItemId() )
		{
		case R.id.action_addCourse:
			semester.addCourse( new Course() );
			adapter.notifyDataSetChanged();
			return true;

		case R.id.action_settings:
			return true;

		default:
			return super.onOptionsItemSelected( item );
		}
	}

	public class PagerAdapter
			extends FragmentStatePagerAdapter
	{
		public PagerAdapter( FragmentManager fm, Semester semester )
		{
			super( fm );
		}

		@Override
		public Fragment getItem( int position )
		{
			position -= 1;

			if ( position < 0 )
			{
				return SemesterFragment.newInstance( semester );
			}
			else
			{
				return CourseFragment.newInstance( semester.getCourseByPosition( position ) );
			}
		}

		@Override
		public int getCount()
		{
			return semester.getCourses().size() + 1;
		}

		@Override
		public CharSequence getPageTitle( int position )
		{
			position -= 1;

			if ( position < 0 )
			{
				return semester.getTitle();
			}
			else
			{
				return semester.getCourseByPosition( position ).getTitle();
			}
		}
	}
}
