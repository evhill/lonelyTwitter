package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ehill on 9/16/15.
 */
public abstract class NeutralTweet extends Tweet{

    public NeutralTweet(String text, Date date) {
        super(text, date);

    }
    public NeutralTweet(String text) {
        super(text);
    }
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return this.date;
    }


    public abstract String sendMood();

}
