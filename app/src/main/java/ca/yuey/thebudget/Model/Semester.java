package ca.yuey.thebudget.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;

/**
 * Created by Yuey on 31/12/2014.
 */
public class Semester
{
	private String                          title   = "";
	private String                          disc    = "";
	private LinkedHashMap< String, Course > courses = new LinkedHashMap<>();

	public Semester()
	{
		title = Calendar.getInstance().get( Calendar.MONTH )
				+ " " +
				Calendar.getInstance().get( Calendar.YEAR )
				+ " Semester";
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle( String title )
	{
		this.title = title;
	}

	public String getDisc()
	{
		return disc;
	}

	public void setDisc( String disc )
	{
		this.disc = disc;
	}

	public void addCourse( Course course )
	{
		courses.put( course.getTitle(), course );
	}

	public Course getCourse( String title )
	{
		return courses.get( title );
	}
}
