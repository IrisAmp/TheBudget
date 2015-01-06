package ca.yuey.thebudget.data;

import java.util.Calendar;

/**
 * Created by Yuey on 01/01/2015.
 */
public interface Gradable
		extends Comparable< Gradable >
{
	public abstract String getTitle();

	public abstract String getDesc();

	public abstract Calendar getDue();

	public abstract float getGrade();

	public abstract void setGrade( float score );

	public abstract float getMax();

	public abstract String getPriority();
}
