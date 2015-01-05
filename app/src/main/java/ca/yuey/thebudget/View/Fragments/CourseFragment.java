package ca.yuey.thebudget.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;

import ca.yuey.thebudget.Model.Course;
import ca.yuey.thebudget.R;

/**
 * Created by Yuey on 03/01/2015.
 */

public class CourseFragment
		extends Fragment
		implements AdapterView.OnItemSelectedListener
{
	private Course course;

	private EditText    titleET;
	private EditText    creditsET;
	private TableLayout detailTable;
	private EditText    descriptionET;
	private CheckBox    passFailCB;
	private Spinner     gradeSpinner;
	private EditText    gradeEditText;
	private Spinner     prioritySpinner;
	private ImageButton toggleDetailButton;
	private ListView    workLV;

	public static CourseFragment newInstance( Course course )
	{
		CourseFragment result = new CourseFragment();
		return result;
	}

	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState )
	{
		View resultView = inflater.inflate( R.layout.fragment_course, container, false );

		getLayoutHandles( resultView );
		setupSpinners();
		setupButtons();

		return resultView;
	}

	private void setupButtons()
	{

		toggleDetailButton.setOnClickListener( new View.OnClickListener()
		{
			@Override
			public void onClick( View v )
			{
				int detailVisibility = CourseFragment.this.detailTable.getVisibility();

				if (detailVisibility == View.VISIBLE)
				{
					CourseFragment.this.detailTable.setVisibility( View.GONE );
					CourseFragment.this.toggleDetailButton.setImageResource( R.drawable.ic_expand_dark );
				}
				else
				{
					CourseFragment.this.detailTable.setVisibility( View.VISIBLE );
					CourseFragment.this.toggleDetailButton.setImageResource( R.drawable.ic_collapse_dark );
				}
			}
		} );
	}

	private void getLayoutHandles( View v )
	{
		titleET =               (EditText) v.findViewById( R.id.fragmentCourse_title );
		creditsET =             (EditText) v.findViewById( R.id.fragmentCourse_credits );
		detailTable =        (TableLayout) v.findViewById( R.id.fragmentCourse_detailTable );
		descriptionET =         (EditText) v.findViewById( R.id.fragmentCourse_desc );
		passFailCB =            (CheckBox) v.findViewById( R.id.fragmentCourse_passFailCheckBox);
		gradeSpinner =           (Spinner) v.findViewById( R.id.fragmentCourse_gradeSpinner );
		//gradeEditText =         (EditText) v.findViewById( R.id.fragmentCourse_gradeEditText );
		prioritySpinner =        (Spinner) v.findViewById( R.id.fragmentCourse_prioritySpinner );
		toggleDetailButton = (ImageButton) v.findViewById( R.id.fragmentCourse_toggleDetailButton );
		workLV =                (ListView) v.findViewById( R.id.fragmentCourse_workListView );
	}

	private void setupSpinners()
	{
		ArrayAdapter<CharSequence>
				adapter1 = ArrayAdapter.createFromResource( this.getActivity(), R.array.grades,     R.layout.spinneritem_simple_centered_item ),
				adapter2 = ArrayAdapter.createFromResource( this.getActivity(), R.array.priorities, R.layout.spinneritem_simple_centered_item );

		adapter1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
		adapter2.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

		gradeSpinner.setAdapter( adapter1 );
		gradeSpinner.setSelection( 1 ); // A

		prioritySpinner.setAdapter( adapter2 );
		prioritySpinner.setSelection( 2 ); // Normal
	}

	

	@Override
	public void onItemSelected( AdapterView< ? > parent, View view, int position, long id )
	{
		CharSequence what = (CharSequence) parent.getItemAtPosition( position );
	}

	@Override
	public void onNothingSelected( AdapterView< ? > parent )
	{

	}
}
