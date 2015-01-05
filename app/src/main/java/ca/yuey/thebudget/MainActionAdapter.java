package ca.yuey.thebudget;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Yuey on 01/01/2015.
 */
public class MainActionAdapter
		extends RecyclerView.Adapter< MainActionAdapter.ViewHolder >
{
	private ArrayList< Gradable > mData;

	public MainActionAdapter( ArrayList< Gradable > data )
	{
		mData = data;
	}

	@Override
	public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i )
	{
		View v = LayoutInflater.from( viewGroup.getContext() )
							   .inflate( R.layout.rvmain_actioncard, viewGroup, false );

		// Setup view layout here

		ViewHolder holder = new ViewHolder( v );
		return holder;
	}

	@Override
	public void onBindViewHolder( ViewHolder viewHolder, int i )
	{
		Gradable item = mData.get( i );

		viewHolder.title.setText( item.getTitle() );
		viewHolder.subtitle.setText( item.getDesc() );
		SimpleDateFormat dateFormat = new SimpleDateFormat( "E, LLL d @ h:mm a", Locale
				.getDefault() );
		viewHolder.dueDate.setText( "Due: " + dateFormat.format( item.getDue()
																	 .getTime() ) );
		viewHolder.priority.setText( item.getPriority() );
		viewHolder.itemHint.setText( "You need to ace this item to stay on budget." ); // TODO: FIX
		linkSeekBarToEntry( viewHolder.entrySeekBar, viewHolder.entryEditText );
		linkButtonListeners( viewHolder.buttonBarEnter, viewHolder.buttonBarMulligan );
	}

	@Override
	public int getItemCount()
	{
		return mData.size();
	}

	private void linkSeekBarToEntry( final SeekBar entrySeekBar, final EditText entryEditText )
	{
		entrySeekBar.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener()
		{
			private int newProgress = -1;

			@Override
			public void onProgressChanged( SeekBar seekBar, int progress, boolean fromUser )
			{
				if ( fromUser )
				{
					newProgress = progress;
				}
				else
				{
					newProgress = -1;
				}
			}

			@Override
			public void onStartTrackingTouch( SeekBar seekBar )
			{

			}

			@Override
			public void onStopTrackingTouch( SeekBar seekBar )
			{
				if ( newProgress >= 0 )
					entryEditText.setText( String.valueOf( newProgress ) );
			}
		} );

		entryEditText.addTextChangedListener( new TextWatcher()
		{
			@Override
			public void beforeTextChanged( CharSequence s, int start, int count, int after )
			{

			}

			@Override
			public void onTextChanged( CharSequence s, int start, int before, int count )
			{
				if ( s != null && s.length() != 0 )
				{
					entrySeekBar.setProgress( Integer.parseInt( s.toString() ) );
				}
				else
				{
					entrySeekBar.setProgress( 0 );
				}
			}

			@Override
			public void afterTextChanged( Editable s )
			{

			}
		} );
	}

	private void linkButtonListeners( Button enter, Button mulligan )
	{
		enter.setOnClickListener( new View.OnClickListener()
		{
			@Override
			public void onClick( View v )
			{
				// TODO
			}
		} );

		mulligan.setOnClickListener( new View.OnClickListener()
		{
			@Override
			public void onClick( View v )
			{
				// TODO
			}
		} );
	}

	public static class ViewHolder
			extends RecyclerView.ViewHolder
	{
		public TextView title;
		public TextView subtitle;
		public TextView dueDate;
		public TextView priority;
		public TextView itemHint;
		public SeekBar  entrySeekBar;
		public EditText entryEditText;
		public Button   buttonBarEnter;
		public Button   buttonBarMulligan;

		public ViewHolder( View itemView )
		{
			super( itemView );
			title = (TextView) itemView.findViewById( R.id.rvMain_cardView_title );
			subtitle = (TextView) itemView.findViewById( R.id.rvMain_cardView_subtitle );
			dueDate = (TextView) itemView.findViewById( R.id.rvMain_cardView_dueDate );
			priority = (TextView) itemView.findViewById( R.id.rvMain_cardView_priority );
			itemHint = (TextView) itemView.findViewById( R.id.rvMain_cardView_itemHint );
			entrySeekBar = (SeekBar) itemView.findViewById( R.id.rvMain_cardView_entrySeekBar );
			entryEditText = (EditText) itemView.findViewById( R.id.rvMain_cardView_entryEditText );
			buttonBarEnter = (Button) itemView.findViewById( R.id.rvMain_cardView_buttonBar_Enter );
			buttonBarMulligan = (Button) itemView.findViewById( R.id.rvMain_cardView_buttonBar_Mulligan );
		}
	}
}
