package vaccination_analysis.twitterAPI;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterHandler {

	// returns tweets from a certain user
	public static List<String> getTweetsFromUser(String username) {

		System.out.println("getTweetsFromUser: " + username);
		Twitter twitter = TwitterFactory.getSingleton();
		List<Status> statuses = new ArrayList();
		ArrayList<String> tweets = new ArrayList();
		try {
			// receice statuses from certain username
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
			result = twitter.getFollowersIDs(username, -1).getIDs().length;

		} catch (TwitterException e) {
			e.printStackTrace();
			System.out.println(username + "'s Followers could not be counted");
		}
		return result;
	}

	public int getFriends(String username) {
		Twitter twitter = TwitterFactory.getSingleton();
		int result = 0;
		try {
			result = twitter.getFriendsIDs(username, -1).getIDs().length;

		} catch (TwitterException e) {
			e.printStackTrace();
			System.out.println(username + "'s Friends could not be counted");
		}
		return result;
	}

	public static int getMessagesFavorited(String username) {
		return 0;		
	}

	public static int getmeanNumberOfHashtagsInTweet(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int meanNumberOfMentionsInTweet(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int numerOfTweetsRetweetedByUser(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int numberOfDaysOnTwitter(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int numberOfMessagesFavorited(String username) {
		return 0;
		// TODO Auto-generated method stub
		
	}
}
