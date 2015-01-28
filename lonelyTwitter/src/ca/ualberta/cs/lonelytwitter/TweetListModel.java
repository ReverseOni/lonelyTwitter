package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetListModel {
	
	private int count;
	private ArrayList<LonelyTweetModel> tweetList;
	

	public TweetListModel() {
		count = 0;
		tweetList = new ArrayList<LonelyTweetModel>();
		
	}

	public int getCount() {
		
		return count;
	}

	public ArrayList<LonelyTweetModel> getTweets() {
		
		return tweetList;
	}

	public void addTweet(LonelyTweetModel tweet) {
		tweetList.add(tweet);
		count+=1;
		
	}

}
