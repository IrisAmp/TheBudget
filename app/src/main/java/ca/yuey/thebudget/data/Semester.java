package ca.yuey.thebudget.data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Observable;

/**
 * Created by Yuey on 31/12/2014.
 */
public class Semester
		implements Serializable
{
	private String                           title   = "";
	private String                           disc    = "";
	private LinkedHashMap< Integer, Course > courses = new LinkedHashMap<>();

	public Semester()
	{
		SimpleDateFormat df = new SimpleDateFormat( "MMMM yyyy" );
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
		courses.put( course.id, course );
	}

	public Course getCourse( int courseID )
	{
		return courses.get( courseID );
	}

	public Course getCourseByPosition( int position )
	{
		if ( position < 0 || position >= courses.size() )
		{
			throw new ArrayIndexOutOfBoundsException();
		}

		Iterator< Course > it = courses.values().iterator();
		for ( int i = 0; i < position; i++ )
		{
			it.next();
		}

		return it.next();
	}

	public Collection< Course > getCourses()
	{
		return this.courses.values();
	}
}
