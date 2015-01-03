package ca.yuey.thebudget.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

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

	private EditText titleET;
	private EditText creditsET;
	private EditText descriptionET;
	private CheckBox passFailCB;
	private Button   autoGoalButton;
	private Spinner  goalSpinner;
	private EditText goalET;

	public static CourseFragment newInstance( int index )
	{
		CourseFragment result = new CourseFragment();
		return result;
	}

	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState )
	{
		View resultView = inflater.inflate( R.layout.fragment_course, container, false );

		getLayoutHandles( resultView );
		setupSpinner();

		return resultView;
	}

	private void getLayoutHandles( View v )
	{
		titleET = (EditText) v.findViewById( R.id.fragmentCourse_title );
		creditsET = (EditText) v.findViewById( R.id.fragmentCourse_credits );
		descriptionET = (EditText) v.findViewById( R.id.fragmentCourse_subtitle );
		passFailCB = (CheckBox) v.findViewById( R.id.fragmentCourse_goalPassFailCheckbox );
		autoGoalButton = (Button) v.findViewById( R.id.fragmentCourse_button_autoGoal );
		goalSpinner = (Spinner) v.findViewById( R.id.fragmentCourse_goalSpinner );
		goalET = (EditText) v.findViewById( R.id.fragmentCourse_goalEditText );
	}

	private void setupSpinner()
	{
		ArrayAdapter< CharSequence > aryAdapter = ArrayAdapter.createFromResource( this
				.getActivity(), R.array.grades, android.R.layout.simple_spinner_dropdown_item );
		aryAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
		goalSpinner.setAdapter( aryAdapter );
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
