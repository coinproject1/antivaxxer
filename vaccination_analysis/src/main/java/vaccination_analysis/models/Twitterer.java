package vaccination_analysis.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vaccination_analysis.textmining.StringUtilities;
import vaccination_analysis.twitterAPI.TwitterHandler;

public class Twitterer {

	private long userId;
	private List<String> tweets = new ArrayList<String>();
	private String username;
	private int followers = 0;
	private boolean isAntivaxxer = false;

	public Twitterer(long userId, String username, boolean isAntivaxxer, int followers, int friends) {
		this.username = username;
		this.followers = followers;
		this.friends = friends;
		this.userId = userId;
		this.isAntivaxxer = isAntivaxxer;
		
	}

	public void addTweets(List<String> tweetsFromUser) {
		if (tweets.size() != 0) {
			this.tweets.clear();
		}
		this.tweets.addAll(tweetsFromUser);

	}

	@Override
	public String toString() {
		return "username is: " + username + " and he got " + tweets.size()
				+ " tweets.";
	}

	public String getTweetsAsOneString() {
		String result = "";
		Iterator<String> iter = tweets.iterator();

		while (iter.hasNext()) {
			result += iter.next();
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

	public int meanNumberOfHashtagsInTweet() {
		Iterator<String> iter = tweets.iterator();
		int count = 0;
		while (iter.hasNext()) {
			String string = iter.next();
			count += countCharInString(string, '#');

		}
		return count;
	}

	public int meanNumberOfMentionsInTweet() {
		Iterator<String> iter = tweets.iterator();
		int count = 0;
		while (iter.hasNext()) {
			String string = iter.next();
			count += countCharInString(string, '@');

		}
		return count;
	}

	public float meanTextLength() {
		return (this.getTweetsAsOneString().length() / this.tweets.size());
	}

	public int numberOfDaysOnTwitter() {
		return TwitterHandler.numberOfDaysOnTwitter(this.username);
	}

	public int numberOfMessagesFavorited() {
		return TwitterHandler.numberOfMessagesFavorited(this.username);
	}

	public int meanNumberOfUrlsInTweet() {
		Iterator<String> iter = tweets.iterator();
		int count = 0;
		while (iter.hasNext()) {
			String string = iter.next();
			count += searchForHttp(string);

		}
		return count;
	}

	private int searchForHttp(String string) {
		StringUtilities su = new StringUtilities();
		return su.searchForHttp(string);

	}

	private int countCharInString(String string, char c) {
		StringUtilities su = new StringUtilities();
		return su.countCharSequence(string, c);
	}

	public boolean isAntivaxxer() {
		return this.isAntivaxxer;
	}

	public long getUserId() {
		return userId;
	}

}
