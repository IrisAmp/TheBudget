package ca.yuey.thebudget.data;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by Yuey on 01/01/2015.
 */
public interface Gradable
		extends Comparable< Gradable >, Serializable
{
	public abstract String getTitle();

	public abstract void setTitle( String title );

	public abstract String getLongTitle();

	public abstract String getDesc();

	public abstract void setDesc( String desc );

	public abstract Calendar getDue();

	public abstract void setDue( Calendar due );

	public abstract float getGrade();

	public abstract void setGrade( float grade );

	public abstract float getWeight();

	public abstract void setWeight( float weight );

	public abstract float getMax();

	public abstract void setMax( float max );

	public abstract String getPriority();

	public abstract void setPriority( String priority );
}
