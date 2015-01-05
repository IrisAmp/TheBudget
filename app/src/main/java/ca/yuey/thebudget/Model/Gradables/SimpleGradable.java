package ca.yuey.thebudget.Model.Gradables;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ca.yuey.thebudget.Model.Course;

/**
 * Created by Yuey on 02/01/2015.
 */
public class SimpleGradable
		implements Gradable
{
	protected Course parent;
	protected String            title    = "Untitled Item";
	protected String            desc     = "";
	protected GregorianCalendar dueDate  = new GregorianCalendar();
	protected String            priority = "";
	protected float             grade    = 0;
	protected float             maxScore = 0;
	protected float             weight   = 0;

    public SimpleGradable(Course parent)
    {

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
		return /*parent.getTitle() + " " +*/ title;
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

	public void setDue( GregorianCalendar dueDate )
	{
		this.dueDate = dueDate;
	}

	@Override
	public float getGrade()
	{
		return grade;
	}

	@Override
	public void setGrade( float grade )
	{
		this.grade = grade;
	}

	public float getMax()
	{
		return maxScore;
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

	public void setMax( float maxScore )
	{
		this.maxScore = maxScore;
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
	public int compareTo( Gradable another )
	{
		return this.dueDate.compareTo( another.getDue() );
	}


}
