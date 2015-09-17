package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ehill on 9/16/15.
 */
public class SadTweet extends NeutralTweet{

    public SadTweet(String text, Date date) {
        super(text, date);
    }

    public String sendMood(){
        return ": (";
    }

}
