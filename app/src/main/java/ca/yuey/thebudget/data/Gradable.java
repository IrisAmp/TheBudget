package ca.yuey.thebudget.data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Observable;

/**
 * Created by Yuey on 01/01/2015.
 */
public interface Gradable
		extends Comparable< Gradable >, Serializable
{
	public abstract String getTitle();

	public abstract String getLongTitle();

	public abstract String getDesc();

	public abstract Calendar getDue();

	public abstract float getGrade();

	public abstract float getWeight();

	public abstract float getMax();

	public abstract String getPriority();
}
