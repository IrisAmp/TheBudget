package ca.yuey.thebudget.Model.Gradables;

import ca.yuey.thebudget.Model.Course;

/**
 * Created by Yuey on 2015-01-05.
 */
public class FinalExam
extends SimpleGradable
{
    public FinalExam(Course parent)
    {
        super(parent);
        this.title = "Final Exam";
    }
}
