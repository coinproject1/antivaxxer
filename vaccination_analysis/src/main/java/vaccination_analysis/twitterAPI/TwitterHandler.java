package vaccination_analysis.twitterAPI;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterHandler {

	//returns tweets from a certain user
	public static List<String> getTweetsFromUser(String username) {

		System.out.println("getTweetsFromUser: " + username);
		Twitter twitter = TwitterFactory.getSingleton();
		List<Status> statuses = new ArrayList();
		ArrayList<String> tweets = new ArrayList();
		try {
			//receice statuses from certain username
			statuses = twitter.getUserTimeline(username);
			//save every tweet
			for (Status status : statuses) {
				String tweet = status.getText();
				try {
					tweets.add(tweet);
				}
				catch (NullPointerException n) {
					System.out.println("tweet was null");
				}
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		//return saved tweets
		return tweets;
	}
}
