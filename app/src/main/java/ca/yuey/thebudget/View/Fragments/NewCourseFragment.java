package ca.yuey.thebudget.View.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ca.yuey.thebudget.R;

/**
 * Created by Yuey on 03/01/2015.
 */
public class NewCourseFragment
		extends Fragment
{
	private Button                addCourseButton;
	private OnCourseAddedListener courseAddedListener;

	public interface OnCourseAddedListener
	{
		public void onCourseAdded();
	}

	public static NewCourseFragment newInstance()
	{
		NewCourseFragment result = new NewCourseFragment();
		return result;
	}

	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState )
	{
		View resultView = inflater.inflate( R.layout.fragment_addcourse, container, false );

		getLayoutHandles( resultView );
		attachListeners();

		return resultView;
	}

	@Override
	public void onAttach( Activity activity )
	{
		super.onAttach( activity );
		try
		{
			courseAddedListener = (OnCourseAddedListener) activity;
		}
		catch ( ClassCastException e )
		{
			throw new ClassCastException( activity.toString() + " must implement OnCourseAddedListener." );
		}
	}

	private void getLayoutHandles( View resultView )
	{
		addCourseButton = (Button) resultView.findViewById( R.id.fragmentAddCourse_button );
	}

	private void attachListeners()
	{
		addCourseButton.setOnClickListener( new View.OnClickListener()
		{
			@Override
			public void onClick( View v )
			{

			}
		} );
	}
}
