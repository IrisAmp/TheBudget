package ca.yuey.thebudget.application.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import ca.yuey.thebudget.R;
import ca.yuey.thebudget.application.fragment.CourseFragment;
import ca.yuey.thebudget.application.fragment.SemesterFragment;
import ca.yuey.thebudget.data.Course;
import ca.yuey.thebudget.data.Semester;

public class ComposeSemesterActivity
		extends FragmentActivity
		implements CourseFragment.OnDataChangedListener
{
	public static final String ARG_SEMESTER = "composeSemesterActivity_semester";

	private PagerAdapter    adapter;
	private ViewPager       pager;
	private PagerTitleStrip titleStrip;

	private Semester semester = null;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_compose_semester );

		getArgs( savedInstanceState );
		getLayoutHandles();
		initPager();
	}

	private void getArgs( Bundle bundle )
	{
		Semester s = null;

		if ( bundle != null )
		{
			s = (Semester) bundle.get( ARG_SEMESTER );
		}

		if ( s != null )
		{
			this.semester = s;
		}
		else
		{
			this.semester = new Semester();
		}
	}

	private void getLayoutHandles()
	{
		pager = (ViewPager) findViewById( R.id.composeSemester_viewPager );
		titleStrip = (PagerTitleStrip) findViewById( R.id.composeSemester_titleStrip );
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

	@Override
	public void onDataChanged()
	{
		adapter.notifyDataSetChanged();
		titleStrip.invalidate();
	}

	public class PagerAdapter
			extends FragmentStatePagerAdapter
	{
		Semester data;

		public PagerAdapter( FragmentManager fm, Semester semester )
		{
			super( fm );
			this.data = semester;
		}

		@Override
		public Fragment getItem( int position )
		{
			position -= 1;

			if ( position < 0 )
			{
				return SemesterFragment.newInstance( data );
			}
			else
			{
				return CourseFragment.newInstance( data.getCourseByPosition(
						position ) );
			}
		}

		@Override
		public int getCount()
		{
			return data.getCourses().size() + 1;
		}

		@Override
		public CharSequence getPageTitle( int position )
		{
			position -= 1;

			if ( position < 0 )
			{
				return data.getTitle();
			}
			else
			{
				return data.getCourseByPosition( position ).getTitle();
			}
		}
	}
}
