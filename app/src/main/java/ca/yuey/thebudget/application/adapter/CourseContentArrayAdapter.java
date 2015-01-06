package ca.yuey.thebudget.application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

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

            convertView.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        initLayout( holder );
        return convertView;
    }

    private void initLayout(ViewHolder holder)
    {

    }

    private static class ViewHolder
    {
        public EditText title;
		public EditText description;
		public EditText maxPoints;
		public EditText weight;
    }
}
