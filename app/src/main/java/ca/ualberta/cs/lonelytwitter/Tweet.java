package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.IllegalFormatCodePointException;

/**
 * Created by ehill on 9/16/15.
 */
public abstract class Tweet extends Object implements Tweetable {

    /*
        Encapsulation means keep your variables private and make others call your methods to access
        Abstract means that we can't make a normal 'Tweet' anymore. It needs to be specific to
        the sub class
     */
    protected String text;
    protected Date date;

    /*
        static key word: only one instance of a variable is created and is shared between classes
        static methods means you can call it independently of an object
        final key word
     */

    public Tweet(String text, Date date) {
        this.setText(text);
        this.date = date;
    }

    public Tweet(String text) {
        this.setText(text);
        this.date = new Date();
    }

    /*
        Makes sure that the people using your variables are using them
        correctly. ie: can't set  the amount of characters in a tweet
        to more than 140 characters
     */
    public String getText() {

        return text;
    }

    public void setText(String text){
        //just having the 'if' isn't great. If the tweet is too long it will do nothing to tell the
        //person that they have done something wrong.
        if(text.length() <= 140){
            this.text = text;
        } else {
            //throw new TweetTooLongException();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
