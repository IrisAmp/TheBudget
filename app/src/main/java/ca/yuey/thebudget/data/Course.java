package ca.yuey.thebudget.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Yuey on 01/01/2015.
 */
public class Course
{
	private String                title   = "";
	private String                disc    = "";
	private ArrayList< Gradable > content = new ArrayList< Gradable >();

	public Course()
	{
		title = "New Course";
		generateContent();
	}

	private void generateContent()
	{
		SimpleGradable exam = new SimpleGradable( this );
		exam.setTitle( "Final Exam" );
		exam.setWeight( 0.50f );
		exam.setMax( 100.f );
		exam.setDue( GregorianCalendar.getInstance() );

		SimpleGradable midterm = new SimpleGradable( this );
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

	public ArrayList< Gradable > getContent()
	{
		return this.content;
	}
}
