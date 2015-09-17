package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ehill on 9/16/15.
 */
public interface Tweetable {
    /*
        Typically in an interface you put lists of methods with no code in them. They don't
        usually have constructors. How they work: like saying "I promise to have these methods". If
        I want to implement this interface I must have these methods. Like a checklist that
        classes need to check off. How to use: like a super class. Instead of 'extends' we use
        'implements'
     */
    public String getText();
    public Date getDate();

}
