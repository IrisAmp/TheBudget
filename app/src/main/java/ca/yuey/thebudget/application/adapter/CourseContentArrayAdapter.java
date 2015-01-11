package ca.yuey.thebudget.application.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import ca.yuey.thebudget.R;
import ca.yuey.thebudget.application.fragment.DatePickerFragment;
import ca.yuey.thebudget.application.fragment.TimePickerFragment;
import ca.yuey.thebudget.data.Gradable;

/**
 * Created by Yuey on 2015-01-05.
 */
public class CourseContentArrayAdapter
		extends ArrayAdapter< Gradable >
		implements DatePickerFragment.OnResultListener, TimePickerFragment.OnResultListener
{
	Activity activity = null;
	private List< Gradable > data;

	private SimpleDateFormat dateFmt = new SimpleDateFormat( "EEE MMM d" );
	private SimpleDateFormat timeFmt = new SimpleDateFormat( "h:mm a" );

	public CourseContentArrayAdapter( Activity activity, List< Gradable > objects )
	{
		super( activity,
			   R.layout.listitem_coursecontent,
			   R.id.listitem_courseContent_title,
			   objects );
		this.activity = activity;
		this.data = objects;
	}

	@Override
	public View getView( int position, View convertView, ViewGroup parent )
	{
		if ( convertView == null )
		{
			LayoutInflater inflater = (LayoutInflater) super.getContext()
															.getSystemService(
																	Context.LAYOUT_INFLATER_SERVICE );
			convertView = inflater.inflate( R.layout.listitem_coursecontent,
											parent,
											false );

			ViewHolder holder = new ViewHolder();
			holder.title = (EditText) convertView.findViewById( R.id.listitem_courseContent_title );
			holder.description = (EditText) convertView.findViewById( R.id.listitem_courseContent_description );
			holder.maxPoints = (EditText) convertView.findViewById( R.id.listitem_courseContent_maxPoints );
			holder.weight = (EditText) convertView.findViewById( R.id.listitem_coursecontent_weight );
			holder.dueDate = (EditText) convertView.findViewById( R.id.listitem_coursecontent_date );
			holder.dueTime = (EditText) convertView.findViewById( R.id.listitem_coursecontent_time );

			convertView.setTag( holder );
		}

		ViewHolder holder = (ViewHolder) convertView.getTag();
		initLayout( position, holder );
		return convertView;
	}

	private void initLayout( int index, ViewHolder holder )
	{
		Gradable item = data.get( index );

		holder.title.setText( item.getTitle() );
		//holder.description.setText( item.getDesc() );
		holder.maxPoints.setText( String.valueOf( item.getMax() ) );
		holder.weight.setText( String.valueOf( item.getWeight() ) );
		holder.dueDate.setText( dateFmt.format( item.getDue().getTime() ) );
		holder.dueTime.setText( timeFmt.format( item.getDue().getTime() ) );

		setupTextListeners( index, holder );
		setupDateTimePickers( index, holder );
	}

	private void setupTextListeners( final int index, ViewHolder holder )
	{
		holder.title.addTextChangedListener( new TextWatcher()
		{
			@Override
			public void beforeTextChanged( CharSequence s, int start, int count, int after ) {}

			@Override
			public void onTextChanged( CharSequence s, int start, int before, int count ) {}

			@Override
			public void afterTextChanged( Editable s )
			{
				data.get( index ).setTitle( s.toString() );
			}
		} );

		holder.description.addTextChangedListener( new TextWatcher()
		{
			@Override
			public void beforeTextChanged( CharSequence s, int start, int count, int after ) {}

			@Override
			public void onTextChanged( CharSequence s, int start, int before, int count ) {}

			@Override
			public void afterTextChanged( Editable s )
			{
				data.get( index ).setDesc( s.toString() );
			}
		} );

		holder.maxPoints.addTextChangedListener( new TextWatcher()
		{
			@Override
			public void beforeTextChanged( CharSequence s, int start, int count, int after ) {}

			@Override
			public void onTextChanged( CharSequence s, int start, int before, int count ) {}

			@Override
			public void afterTextChanged( Editable s )
			{
				try
				{
					data.get( index ).setMax( Float.valueOf( s.toString() ) );
				}
				catch ( Exception e )
				{
					data.get( index ).setMax( 1f );
				}
			}
		} );

		holder.weight.addTextChangedListener( new TextWatcher()
		{
			@Override
			public void beforeTextChanged( CharSequence s, int start, int count, int after ) {}

			@Override
			public void onTextChanged( CharSequence s, int start, int before, int count ) {}

			@Override
			public void afterTextChanged( Editable s )
			{
				try
				{
					data.get( index )
						.setWeight( Float.valueOf( s.toString() ) );
				}
				catch ( Exception e )
				{
					data.get( index ).setWeight( 1f );
				}
			}
		} );
	}

	private void setupDateTimePickers( final int index, ViewHolder holder )
	{
		holder.dueDate.setOnFocusChangeListener( new View.OnFocusChangeListener()
		{
			@Override
			public void onFocusChange( View v, boolean hasFocus )
			{
				if ( hasFocus ) DatePickerFragment.newInstance(
						CourseContentArrayAdapter.this,
						index )
												  .show( activity.getFragmentManager(),
														 "DatePicker" );
				v.clearFocus();
			}
		} );

		holder.dueTime.setOnFocusChangeListener( new View.OnFocusChangeListener()
		{
			@Override
			public void onFocusChange( View v, boolean hasFocus )
			{
				if ( hasFocus ) TimePickerFragment.newInstance(
						CourseContentArrayAdapter.this,
						index )
												  .show( activity.getFragmentManager(),
														 "TimePicker" );
				v.clearFocus();
			}
		} );
	}

	@Override
	public void onDatePickerResult( int index, int year, int month, int day )
	{
		Calendar c = data.get( index ).getDue();
		c.set( Calendar.YEAR, year );
		c.set( Calendar.MONTH, month );
		c.set( Calendar.DATE, day );
		notifyDataSetChanged();
	}

	@Override
	public void onTimePickerResult( int index, int hour, int minute )
	{
		Calendar c = data.get( index ).getDue();
		c.set( Calendar.HOUR, hour );
		c.set( Calendar.MINUTE, minute );
		notifyDataSetChanged();
	}

	private static class ViewHolder
	{
		public EditText title;
		public EditText description;
		public EditText maxPoints;
		public EditText weight;
		public EditText dueDate;
		public EditText dueTime;
	}
}
