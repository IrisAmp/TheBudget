package ca.yuey.thebudget.application.activity;

import android.app.Activity;
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
		extends Activity
{
	public static final String ARG_SEMESTER = "composeSemesterActivity_semester";

	private Semester semester = null;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_compose_semester );

		getLayoutHandles();
	}

	private void getLayoutHandles()
	{

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
			return true;

		case R.id.action_settings:
			return true;

		default:
			return super.onOptionsItemSelected( item );
		}
	}
}
