package ca.yuey.thebudget.application.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import ca.yuey.thebudget.R;
import ca.yuey.thebudget.data.Semester;

/**
 * Created by Yuey on 03/01/2015.
 */
public class SemesterFragment
		extends Fragment
{
	public static String ARG_SEMESTER = "semester";

	private Semester semester;

	private EditText title;

	public static SemesterFragment newInstance( Semester semester )
	{
		SemesterFragment result = new SemesterFragment();

		Bundle args = new Bundle(  );
		args.putSerializable( ARG_SEMESTER, semester );
		result.setArguments( args );

		return result;
	}

	@Override
	public void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		if (getArguments() != null)
		{
			semester = (Semester) getArguments().getSerializable( ARG_SEMESTER );
		}
	}

	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState )
	{
		View resultView = inflater.inflate( R.layout.fragment_semester,
											container,
											false );

		getLayoutHandles( resultView );
		setupEditTexts();

		return resultView;
	}

	private void setupEditTexts()
	{
		title.addTextChangedListener( new TextWatcher()
		{
			@Override
			public void beforeTextChanged( CharSequence s, int start, int count, int after )
			{
				// Do nothing
			}

			@Override
			public void onTextChanged( CharSequence s, int start, int before, int count )
			{
				// Do nothing
			}

			@Override
			public void afterTextChanged( Editable s )
			{
				semester.setTitle( s.toString() );
			}
		} );
	}

	private void getLayoutHandles( View v )
	{
		title = (EditText) v.findViewById( R.id.fragment_semester_title );
	}
}
