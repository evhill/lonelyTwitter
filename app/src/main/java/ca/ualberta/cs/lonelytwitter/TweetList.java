package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

/**
 * Created by ehill on 9/30/15.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet) throws IllegalArgumentException{
        //if tweet is not duplicate add else fail
        if(!(tweets.contains(tweet))){
            tweets.add(tweet);
        }else{
            throw new IllegalArgumentException("This is a duplicate!");
        }
    }

    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public int getCount(TweetList tweetList){
        return size(tweetList);
    }

}
