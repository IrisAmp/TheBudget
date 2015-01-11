package ca.yuey.thebudget.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Yuey on 01/01/2015.
 */
public class Course
		implements Serializable
{
	private static int nextID = 0;

	public final int id;

	private String                title   = "";
	private String                disc    = "";
	private ArrayList< Gradable > content = new ArrayList<>();
	private int credits;

	public Course()
	{
		this.id = nextID++;
		title = "New Course " + String.valueOf( 100 + id );
		generateContent();
	}

	private void generateContent()
	{
		SimpleGradable exam = new SimpleGradable( this );
		exam.setTitle( "Final Exam" );
		exam.setWeight( 0.50f );
		exam.setMax( 100.f );
		Calendar examDate = GregorianCalendar.getInstance();
		examDate.add( Calendar.MONTH, 3 );
		exam.setDue( examDate );

		SimpleGradable midterm = new SimpleGradable( this );
		midterm.setTitle( "Midterm" );
		midterm.setWeight( 0.30f );
		midterm.setMax( 50.f );
		Calendar mtDate = GregorianCalendar.getInstance();
		mtDate.add( Calendar.MONTH, 2 );
		midterm.setDue( mtDate );

		SimpleGradable assignment = new SimpleGradable( this );
		assignment.setTitle( "Assignment" );
		assignment.setWeight( 0.20f );
		assignment.setMax( 20.f );
		Calendar assignmentDate = GregorianCalendar.getInstance();
		assignmentDate.add( Calendar.MONTH, 1 );
		assignment.setDue( assignmentDate );

		content.add( exam );
		content.add( midterm );
		content.add( assignment );
	}

	public int getCredits()
	{
		return credits;
	}

	public void setCredits( int credits )
	{
		this.credits = credits;
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

