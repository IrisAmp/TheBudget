package ca.yuey.thebudget.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import ca.yuey.thebudget.Model.Course;
import ca.yuey.thebudget.Model.Semester;
import ca.yuey.thebudget.R;
import ca.yuey.thebudget.View.Fragments.CourseFragment;
import ca.yuey.thebudget.View.Fragments.SemesterFragment;

public class ComposeSemesterActivity
	extends FragmentActivity
{
	private PagerAdapter    adapter;
	private ViewPager       pager;

	private Semester            semester = new Semester();
	private ArrayList< Course > courses  = new ArrayList<>();

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
		adapter = new PagerAdapter( getSupportFragmentManager(), semester, courses );
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
		case R.id.action_addCourse:
			courses.add( new Course() );
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
		public PagerAdapter( FragmentManager fm, Semester semester, ArrayList< Course > courses )
		{
			super( fm );
		}

		@Override
		public Fragment getItem( int position )
		{
			position -= 1;

			if ( position < 0 ) return SemesterFragment.newInstance( semester );
			else                return CourseFragment.newInstance( courses.get( position ) );
		}

		@Override
		public int getCount()
		{
			return courses.size() + 1;
		}

		@Override
		public CharSequence getPageTitle( int position )
		{
			position -= 1;

			if ( position < 0 ) return semester.getTitle();
			else                return courses.get( position ).getTitle();
		}
	}
}
