package vaccination_analysis.twitterAPI;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import vaccination_analysis.models.Tweet;

public class TwitterHandler {

	public TwitterHandler() {

	}

	public static List<Tweet> getTweetsFromUser(String username) {

		System.out.println("getTweetsFromUser: " + username);
		Twitter twitter = TwitterFactory.getSingleton();
		List<Status> statuses = new ArrayList();
		ArrayList<Tweet> tweets = new ArrayList();
		try {
			statuses = twitter.getUserTimeline(username);
			for (Status status : statuses) {
//				Tweet tweet = new Tweet(status.getText(), status
//						.getGeoLocation().toString(), status.getCreatedAt());
				Tweet tweet = new Tweet(status.getText());
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

		return tweets;
	}
}
