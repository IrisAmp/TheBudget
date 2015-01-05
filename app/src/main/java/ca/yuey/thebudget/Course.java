package ca.yuey.thebudget;

import java.util.ArrayList;

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

    public ArrayList< Gradable > getContent()
    {
        return this.content;
    }
}
