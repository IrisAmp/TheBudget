package ca.yuey.thebudget.application.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import ca.yuey.thebudget.R;
import ca.yuey.thebudget.application.adapter.MainActionAdapter;
import ca.yuey.thebudget.data.Course;
import ca.yuey.thebudget.data.Gradable;
import ca.yuey.thebudget.data.SimpleGradable;


public class MainActivity
		extends Activity
{
	private RecyclerView               recyclerView;
	private MainActionAdapter          actionAdapter;
	private RecyclerView.LayoutManager layoutManager;
	private ArrayList< Gradable >      upcomingGradables;

	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );

		getLayoutHandles();

		createMockGradables();

		initRecycler();
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		getMenuInflater().inflate( R.menu.menu_main, menu );
		return true;
	}

	@Override
	public boolean onOptionsItemSelected( MenuItem item )
	{
		switch ( item.getItemId() )
		{
		case R.id.action_viewBudget:
			// TODO
			return true;

		case R.id.action_newSemester:
			Intent intent = new Intent( this, ComposeSemesterActivity.class );
			startActivity( intent );
			return true;

		case R.id.action_viewArchive:
			// TODO
			return true;

		case R.id.action_settings:
			// TODO
			return true;

		default:
			return super.onOptionsItemSelected( item );
		}

	}

	private void getLayoutHandles()
	{
		recyclerView = (RecyclerView) findViewById( R.id.main_recyclerView );
	}

	private void createMockGradables()
	{
		upcomingGradables = new ArrayList<>();

		SimpleGradable item = new SimpleGradable( new Course() );
		item.setTitle( "Assignment 1" );
		item.setDesc( "Mock item 1!" );

		upcomingGradables.add( item );
	}

	private void initRecycler()
	{
		recyclerView.setHasFixedSize( false ); // Set to true if size is not variable for better performance.
		recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
		actionAdapter = new MainActionAdapter( upcomingGradables );
		recyclerView.setAdapter( actionAdapter );
	}
}
