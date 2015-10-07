package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by ehill on 9/30/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    //Make sure that your tests are no dependant on each other
    //Will run tests in any order

    public void testRemoveTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Hi!!");
        tweetList.addTweet(tweet);
        tweetList.removeTweet(tweet);
        assertFalse(tweetList.hasTweet(tweet));

    }
    public void  testHasTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("I'm tired!!");
        assertFalse(tweetList.hasTweet(tweet));
        tweetList.addTweet(tweet);
        assertTrue(tweetList.hasTweet(tweet));

    }
    public void testAddTweet(){

        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Cats!!");
        try {
            tweetList.addTweet(tweet);
            tweetList.addTweet(tweet);
            //We do not want to get to this in this test. The instructions for this
            //assignment mean we want to get to the catch block
            fail();
        }catch (IllegalArgumentException e){
            System.out.println("Just caught an IllegalArgumentException " + e.getMessage());
            assertTrue(true);
        }
    }
    public void testTweetCount(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Hungry!!");
        tweetList.addTweet(tweet);
        tweetList.getCount();
    }
    public void testGetTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Oh look a tweet!!");
        tweetList.addTweet(tweet);

        //example of a poorly written test. If someone calls getTweet
        //with an invalid index you'll get a NullPointer error. But there's
        //not enough time in the lab to fix
        Tweet returnedTweet = tweetList.getTweet(0);
        assertTrue((tweet.date.equals(returnedTweet.date)) &&
                (tweet.getText().equals(returnedTweet.getText())));
    }
    public void testGetTweetType(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Yay Homework D:< !!");
        tweetList.addTweet(tweet);
    }
}
