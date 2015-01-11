package ca.yuey.thebudget.data;

import android.support.annotation.NonNull;

import java.util.Calendar;

/**
 * Created by Yuey on 02/01/2015.
 */
public class SimpleGradable
		implements Gradable
{
	protected Course   parent   = null;
	protected String   title    = "Untitled Item";
	protected String   desc     = "";
	protected Calendar dueDate  = Calendar.getInstance();
	protected String   priority = "";
	protected float    grade    = 0;
	protected float    maxScore = 0;
	protected float    weight   = 0;

	public SimpleGradable( Course parent )
	{
		this.parent = parent;
	}

	public Course getParent()
	{
		return parent;
	}

	public void setParent( Course parent )
	{
		this.parent = parent;
	}

	@Override
	public int compareTo( @NonNull Gradable another )
	{
		int result;

		result = this.dueDate.compareTo( another.getDue() );

		if ( result == 0 )
		{
			result = this.priority.compareTo( another.getPriority() );
		}

		return result;
	}	@Override
	public String getTitle()
	{
		return this.title;
	}

	@Override
	public String getLongTitle()
	{
		return parent.getTitle() + " " + getTitle();
	}

	@Override
	public void setTitle( String title )
	{
		this.title = title;
	}

	@Override
	public String getDesc()
	{
		return this.desc;
	}

	@Override
	public void setDesc( String desc )
	{
		this.desc = desc;
	}

	@Override
	public Calendar getDue()
	{
		return this.dueDate;
	}

	@Override
	public void setDue( Calendar due )
	{
		this.dueDate = due;
	}

	@Override
	public float getGrade()
	{
		return this.grade;
	}

	@Override
	public void setGrade( float grade )
	{
		this.grade = grade;
	}

	@Override
	public float getWeight()
	{
		return this.weight;
	}

	@Override
	public void setWeight( float weight )
	{
		this.weight = weight;
	}

	@Override
	public float getMax()
	{
		return this.maxScore;
	}

	@Override
	public void setMax( float max )
	{
		this.maxScore = max;
	}

	@Override
	public String getPriority()
	{
		return this.priority;
	}

	@Override
	public void setPriority( String priority )
	{
		this.priority = priority;
	}


}
