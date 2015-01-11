package ca.yuey.thebudget.application.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

/**
 * Created by Yuey on 10/01/2015.
 */
public class DatePickerFragment
		extends DialogFragment
		implements DatePickerDialog.OnDateSetListener
{
	private OnResultListener callbackTarget;
	private int              index;

	public DatePickerFragment() {}

	public static DatePickerFragment newInstance( OnResultListener receiver, int index )
	{
		DatePickerFragment result = new DatePickerFragment();

		result.callbackTarget = receiver;
		result.index = index;

		return result;
	}

	@Override
	public Dialog onCreateDialog( Bundle savedInstanceState )
	{
		return new DatePickerDialog( getActivity(), this, 0, 0, 0 );
	}

	@Override
	public void onDateSet( DatePicker view, int year, int monthOfYear, int dayOfMonth )
	{
		callbackTarget.onDatePickerResult( index,
										   year,
										   monthOfYear,
										   dayOfMonth );
	}

	public interface OnResultListener
	{
		public abstract void onDatePickerResult( int index, int year, int month, int day );
	}
}
