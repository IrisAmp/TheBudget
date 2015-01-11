package ca.yuey.thebudget.application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import ca.yuey.thebudget.R;
import ca.yuey.thebudget.data.Gradable;

/**
 * Created by Yuey on 10/01/2015.
 */
public class SimpleCourseContentArrayAdapter
		extends ArrayAdapter< Gradable >
{
	List< Gradable > data;

	public SimpleCourseContentArrayAdapter( Context context, int resource, int textViewResourceId, List< Gradable > objects )
	{
		super( context, resource, textViewResourceId, objects );
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
			convertView = inflater.inflate( R.layout.listitem_simplecoursecontent,
											parent,
											false );

			ViewHolder holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById( R.id.listitem_simpleCourseContent_title );
			holder.dueDate = (TextView) convertView.findViewById( R.id.listitem_simpleCourseContent_dueDateTime );
			holder.fromNowDate = (TextView) convertView.findViewById( R.id.listitem_simpleCourseContent_fromNowDateTime );

			convertView.setTag( holder );
		}

		Gradable item = data.get( position );

		SimpleDateFormat sdf1 = new SimpleDateFormat( "E LLL d" );

		ViewHolder holder = (ViewHolder) convertView.getTag();
		holder.title.setText( item.getTitle() );
		holder.dueDate.setText( sdf1.format( item.getDue().getTime() ) );

		return convertView;
	}

	private static class ViewHolder
	{
		TextView title;
		TextView dueDate;
		TextView fromNowDate;
	}
}
