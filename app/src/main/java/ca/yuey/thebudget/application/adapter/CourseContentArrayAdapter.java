package ca.yuey.thebudget.application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import ca.yuey.thebudget.R;
import ca.yuey.thebudget.data.Gradable;

/**
 * Created by Yuey on 2015-01-05.
 */
public class CourseContentArrayAdapter
    extends ArrayAdapter
{
	private Context          ctx;
	private List< Gradable > data;

	public CourseContentArrayAdapter( Context context, List objects )
	{
		super( context, R.layout.listitem_coursecontent, R.id.listitem_courseContent_title, objects );
		this.ctx = context;
		this.data = objects;
	}

	@Override
	public View getView( int position, View convertView, ViewGroup parent )
	{
		if ( convertView == null )
		{
			LayoutInflater inflater = (LayoutInflater) ctx.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView = inflater.inflate( R.layout.listitem_coursecontent, parent, false);

            ViewHolder holder = new ViewHolder();
            holder.title = (EditText) convertView.findViewById( R.id.listitem_courseContent_title );
			holder.description = (EditText) convertView.findViewById( R.id.listitem_courseContent_description );
			holder.maxPoints = (EditText) convertView.findViewById( R.id.listitem_courseContent_maxPoints );
			holder.weight = (EditText) convertView.findViewById( R.id.listitem_coursecontent_weight );
			holder.dueDate = (EditText) convertView.findViewById( R.id.listitem_coursecontent_date );
			holder.dueTime = (EditText) convertView.findViewById( R.id.listitem_coursecontent_time );

            convertView.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        initLayout( position, holder );
        return convertView;
    }

    private void initLayout(int index, ViewHolder holder)
    {
		Gradable item = data.get( index );
		SimpleDateFormat dateFmt = new SimpleDateFormat( "EEE MMM d" );
		SimpleDateFormat timeFmt = new SimpleDateFormat( "h:mm a" );

		holder.title.setText( item.getTitle() );
		//holder.description.setText( item.getDesc() );
		holder.maxPoints.setText( String.valueOf( item.getMax() ) );
		holder.weight.setText( String.valueOf( item.getWeight() ) );
		holder.dueDate.setText( dateFmt.format( item.getDue().getTime() ) );
		holder.dueTime.setText( timeFmt.format( item.getDue().getTime() ) );
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
