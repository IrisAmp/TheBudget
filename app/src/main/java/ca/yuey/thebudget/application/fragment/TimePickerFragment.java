package ca.yuey.thebudget.application.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;

/**
 * Created by Yuey on 10/01/2015.
 */
public class TimePickerFragment
		extends DialogFragment
		implements TimePickerDialog.OnTimeSetListener
{
	private OnResultListener callbackTarget;
	private int              index;

	public TimePickerFragment() {}

	public static TimePickerFragment newInstance( OnResultListener receiver, int index )
	{
		TimePickerFragment result = new TimePickerFragment();

		result.callbackTarget = receiver;
		result.index = index;

		return result;
	}

	@Override
	public Dialog onCreateDialog( Bundle savedInstanceState )
	{
		return new TimePickerDialog( getActivity(),
									 this,
									 0,
									 0,
									 DateFormat.is24HourFormat( getActivity() ) );
	}

	@Override
	public void onTimeSet( android.widget.TimePicker view, int hourOfDay, int minute )
	{
		callbackTarget.onTimePickerResult( index, hourOfDay, minute );
	}

	public interface OnResultListener
	{
		public abstract void onTimePickerResult( int index, int hour, int minute );
	}
}