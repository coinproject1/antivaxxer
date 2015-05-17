package vaccination_analysis.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vaccination_analysis.twitterAPI.TwitterHandler;

abstract class Twitterer {

	private List<String> tweets = new ArrayList<String>();
	private String username;
	private int followers = 0;

	public Twitterer(String username, int followers, int friends) {
		this.username = username;
		this.followers = followers;
		this.friends = friends;
	}

	public void addTweets(List<String> tweetsFromUser) {
		if (tweets.size() != 0) {
			this.tweets.clear();
		}
		this.tweets.addAll(tweetsFromUser);

	}
	
	@Override
	public String toString() {
		return "username is: " + username + " and he got " + tweets.size() + " tweets.";
	}
	public String getTweetsAsOneString() {
		String result = "";
		Iterator<String> iter = tweets.iterator();
		
		while (iter.hasNext()) {
			result+=iter.next();
		}
		return result;
	}

	public int getFollowers() {
		return followers;
	}

	public int getFriends() {
		return friends;
	}

	private int friends = 0;

	public String getUsername() {
		return this.username;
	}

	public List<String> getTweets() {
		return tweets;
	}

	public void AddTweet(String tweet) {
		this.tweets.add(tweet);
	}

	public int messagesPosted() {
		return this.tweets.size();
	}

	// TODO implement method
	public int messagesFavorited() {		
		return TwitterHandler.getMessagesFavorited(this.username);
	}
	// TODO implement method
	public int meanNumberOfHashtagsInTweet() {
		return TwitterHandler.getmeanNumberOfHashtagsInTweet(this.username);
	}
	// TODO implement method
	public int meanNumberOfMentionsInTweet() {
		return TwitterHandler.meanNumberOfMentionsInTweet(this.username);
	}
	// TODO implement method
	public float meanTextLength() {
		return (this.getTweetsAsOneString().length() / this.tweets.size());
	}
	// TODO implement method
	public int numerOfTweetsRetweetedByUser() {
		return TwitterHandler.numerOfTweetsRetweetedByUser(this.username);
	}
	// TODO implement method
	public int numberOfDaysOnTwitter() {
		return TwitterHandler.numberOfDaysOnTwitter(this.username);
	}
	// TODO implement method
	public int numberOfMessagesFavorited() {
		return TwitterHandler.numberOfMessagesFavorited(this.username);
	}
	// TODO implement method
	public int meanNumberOfUrlsInTweet() {
		Iterator<String> iter = tweets.iterator();
		int count = 0;
		while (iter.hasNext()) {
			String string = iter.next();
			if (string.contains("http://") || string.contains("www")) {
				count+=1;
			}
		}
		return count;
	}

}
