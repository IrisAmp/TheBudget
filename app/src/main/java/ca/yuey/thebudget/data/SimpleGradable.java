package ca.yuey.thebudget.data;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Observable;

/**
 * Created by Yuey on 02/01/2015.
 */
public class SimpleGradable
		extends Observable
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
	public String getTitle()
	{
		return parent.getTitle() + " " + title;
	}

	public void setTitle( String title )
	{
		this.title = title;
	}

	@Override
	public String getDesc()
	{
		return desc;
	}

	public void setDesc( String desc )
	{
		this.desc = desc;
	}

	@Override
	public Calendar getDue()
	{
		return dueDate;
	}

	public void setDue( Calendar dueDate )
	{
		this.dueDate = dueDate;
	}

	@Override
	public float getGrade()
	{
		return grade;
	}

	public void setGrade( float grade )
	{
		this.grade = grade;
	}

	public float getMax()
	{
		return maxScore;
	}

	public void setMax( float maxScore )
	{
		this.maxScore = maxScore;
	}

	@Override
	public String getPriority()
	{
		return priority;
	}

	public void setPriority( String priority )
	{
		this.priority = priority;
	}

	public float getWeight()
	{
		return weight;
	}

	public void setWeight( float weight )
	{
		this.weight = weight;
	}

	@Override
	public int compareTo( @NonNull Gradable another )
	{
		return this.dueDate.compareTo( another.getDue() );
	}
}
