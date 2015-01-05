package ca.yuey.thebudget;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        SimpleDateFormat df = new SimpleDateFormat("MMMMM yyyy");
		title = df.format( new Date() ) + " Semester";
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
