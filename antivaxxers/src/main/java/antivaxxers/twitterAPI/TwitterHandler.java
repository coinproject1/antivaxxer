package antivaxxers.twitterAPI;

import java.util.ArrayList;
import java.util.List;

import antivaxxers.models.Tweet;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterHandler {

	public List<Tweet> getTweetsFromUser(String username) {

		Twitter twitter = TwitterFactory.getSingleton();
		List<Status> statuses = new ArrayList();
		ArrayList<Tweet> tweets = new ArrayList();
		try {
			statuses = twitter.getUserTimeline("username");
			for (Status status : statuses) {
				Tweet tweet = new Tweet(status.getText(), status.getGeoLocation().toString(), status.getCreatedAt());
				tweets.add(tweet);
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}

		return tweets;
	}
}
