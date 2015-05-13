package vaccination_analysis.models;

import java.util.Iterator;
import java.util.List;

abstract class Twitterer {

	private List<String> tweets;
	private String username;
	private int followers = 0;

	public Twitterer(String username, int followers, int friends) {
		this.username = username;
		this.followers = followers;
		this.friends = friends;
	}

	public void AddTweets(List<String> tweetsFromUser) {
		if (tweets.size() != 0) {
			this.tweets.clear();
		}
		this.tweets.addAll(tweetsFromUser);

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

	// TODO implement methods
	public int messagesFavorited() {
		return 0;
	}

	public int meanNumberOfHashtagsInTweet() {
		return 0;
	}

	public int meanNumberOfMentionsInTweet() {
		return 0;
	}

	public int meanTextLength() {
		return 0;
	}

	public int numerOfTweetsRetweetedByUser() {
		return 0;
	}

	public int numberOfDaysOnTwitter() {
		return 0;
	}

	public int numberOfMessagesFavorited() {
		return 0;
	}

	public int meanNumberOfUrlsInTweet() {
		return 0;
	}

}
