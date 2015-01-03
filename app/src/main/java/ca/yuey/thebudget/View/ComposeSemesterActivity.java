package ca.yuey.thebudget.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import ca.yuey.thebudget.Model.Course;
import ca.yuey.thebudget.Model.Semester;
import ca.yuey.thebudget.R;
import ca.yuey.thebudget.View.Fragments.CourseFragment;
import ca.yuey.thebudget.View.Fragments.NewCourseFragment;
import ca.yuey.thebudget.View.Fragments.SemesterFragment;

public class ComposeSemesterActivity
	extends FragmentActivity
	implements NewCourseFragment.OnCourseAddedListener
{
	private PagerAdapter adapter;
	private ViewPager    pager;

	private Semester            semester = new Semester();
	private ArrayList< Course > courses  = new ArrayList<>();

	private SemesterFragment  semesterFragment;
	private NewCourseFragment newCourseFragment;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_compose_semester );
		getLayoutHandles();
		initPager();
	}

	private void getLayoutHandles()
	{
		pager = (ViewPager) findViewById( R.id.composeSemester_viewPager );
	}

	private void initPager()
	{
		adapter = new PagerAdapter( getSupportFragmentManager() );
		pager.setAdapter( adapter );
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		getMenuInflater().inflate( R.menu.menu_compose_semester, menu );
		return true;
	}

	@Override
	public boolean onOptionsItemSelected( MenuItem item )
	{
		switch ( item.getItemId() )
		{
		default:
			return super.onOptionsItemSelected( item );
		}
	}

	@Override
	public void onCourseAdded()
	{
		courses.add( new Course() );
	}

	public class PagerAdapter
		extends FragmentStatePagerAdapter
	{
		SemesterFragment  semesterFragment  = SemesterFragment.newInstance();
		NewCourseFragment newCourseFragment = NewCourseFragment.newInstance();

		public PagerAdapter( FragmentManager fm )
		{
			super( fm );
		}

		@Override
		public Fragment getItem( int position )
		{
			if ( position == 0 )
			{
				return semesterFragment;
			}
			else if ( position == getCount() - 1 )
			{
				return newCourseFragment;
			}
			else
			{
				return CourseFragment.newInstance( position );
			}
		}

		@Override
		public int getCount()
		{
			return ComposeSemesterActivity.this.courses.size() + 2;
		}

		@Override
		public CharSequence getPageTitle( int position )
		{
			if ( position == 0 )
			{
				return ComposeSemesterActivity.this.semester.getTitle();
			}
			else if ( position == getCount() - 1 )
			{
				return "Add a Course";
			}
			else
			{
				return ComposeSemesterActivity.this.courses.get( position )
														   .getTitle();
			}
		}
	}
}
