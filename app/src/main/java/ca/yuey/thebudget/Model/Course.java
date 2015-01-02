package ca.yuey.thebudget.Model;

import java.util.ArrayList;

import ca.yuey.thebudget.Model.Gradables.Gradable;

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
}
