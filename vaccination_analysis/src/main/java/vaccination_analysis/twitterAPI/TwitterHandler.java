package vaccination_analysis.twitterAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterHandler {

	// returns tweets from a certain user
	@SuppressWarnings("unchecked")
	public static List<String> getTweetsFromUser(String username) {

		System.out.println("getTweetsFromUser: " + username);
		Twitter twitter = TwitterFactory.getSingleton();
		List<Status> statuses = new ArrayList();
		ArrayList<String> tweets = new ArrayList();
		try {
			// receice statuses from certain username
			// TODO
			// PAGING
			statuses = twitter.getUserTimeline(username);
			
			// save every tweet
			for (Status status : statuses) {
				String tweet = status.getText();
				try {
					tweets.add(tweet);
				} catch (NullPointerException n) {
					System.out.println("tweet was null");
				}
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		// return saved tweets
		return tweets;
	}

	public int getFollowers(String username) {
		Twitter twitter = TwitterFactory.getSingleton();
		int result = 0;
		try {
			result = twitter.showUser(username).getFollowersCount();
		} catch (TwitterException e) {
			e.printStackTrace();
			System.out.println(username + "'s Followers could not be counted");
			return -1;
		}
		return result;
	}

	public int getFriends(String username) {
		Twitter twitter = TwitterFactory.getSingleton();
		int result = 0;
		try {
			result = twitter.showUser(username).getFriendsCount();
		} catch (TwitterException e) {
			e.printStackTrace();
			System.out.println(username + "'s Friends could not be counted");
			return -1;
		}
		return result;
	}

	public static int numberOfDaysOnTwitter(String username) {
		Twitter twitter = TwitterFactory.getSingleton();
		Date date;
		try {
			date = twitter.showUser(username).getCreatedAt();
			Date today = new Date();
			return (int) ((today.getTime() - date.getTime()) / 86400000);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public static int numberOfMessagesFavorited(String username) {
		Twitter twitter = TwitterFactory.getSingleton();
		try {
			return twitter.showUser(username).getFavouritesCount();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;

	}

	public long getUserId(String username) {
		Twitter twitter = TwitterFactory.getSingleton();
		try {
			return twitter.showUser(username).getId();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
}
