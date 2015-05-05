package vaccination_analysis.start;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vaccination_analysis.models.Tweet;
import vaccination_analysis.models.Twitterer;
import vaccination_analysis.parsing.TweetsExporter;
import vaccination_analysis.parsing.UsernamesReader;
import vaccination_analysis.twitterAPI.TwitterHandler;

public class StartScan {

	static UsernamesReader usernamesReader = new UsernamesReader();
	TwitterHandler twitterHandler = new TwitterHandler();
	static List<Twitterer> antivaxxerList = new ArrayList();
	static List<Twitterer> provaxxerList = new ArrayList();
	static TweetsExporter tweetsExporter = new TweetsExporter();

	public static void main(String... aArguments) throws IOException {

		System.out.println("Starting scan");
		// read vaxxers from file
		List<String> antivaxxers = usernamesReader.getAntivaxxers();
		List<String> provaxxers = usernamesReader.getProvaxxers();

		// create twitterers from file -> List of Twitterers, anti + pro
		Iterator<String> itr_anti = antivaxxers.iterator();
		Iterator<String> itr_pro = provaxxers.iterator();

		while (itr_anti.hasNext()) {
			String twitterername = itr_anti.next();
			Twitterer twitterer = new Twitterer(twitterername);
			antivaxxerList.add(twitterer);
			System.out.println("twitterer anti added: " + twitterer.getName());

		}
		while (itr_pro.hasNext()) {
			String twitterername = itr_pro.next();
			Twitterer twitterer = new Twitterer(twitterername);
			provaxxerList.add(twitterer);
			System.out.println("twitterer pro added: " + twitterer.getName());
		}

		// get Tweets for every Twitterer
		Iterator<Twitterer> itr_antitw = antivaxxerList.iterator();
		Iterator<Twitterer> itr_protw = provaxxerList.iterator();

		while (itr_antitw.hasNext()) {
			Twitterer currentTwitterer = itr_antitw.next();
			List<Tweet> currentTwitterersTweets = getTweetsFromUser(currentTwitterer);
			
			
			Iterator<Tweet> itr_currentTwitterersTweets = currentTwitterersTweets.iterator();
			while (itr_currentTwitterersTweets.hasNext()) {
				Tweet currentTweet = itr_currentTwitterersTweets.next();
				System.out.println("message from "+ currentTwitterer.getName() + ": "
						+ currentTweet.getMessage());
				//currentTwitterer.addTweet(currentTweet);	
			}
			addTweetsToFiles(currentTwitterersTweets, "protweets.txt");

		}
		while (itr_protw.hasNext()) {
			Twitterer current = itr_protw.next();
			List<Tweet> current_users_tweets = getTweetsFromUser(current);
			Iterator<Tweet> itr_current = current_users_tweets.iterator();
			while (itr_current.hasNext()) {
				//current.addTweet(itr_current.next());
			}
			addTweetsToFiles(current_users_tweets, "protweets.txt");
		}


	}

	private static List<Tweet> getTweetsFromUser(Twitterer user) {
		return TwitterHandler.getTweetsFromUser(user.getName());

	}

	private static void addTweetsToFiles(List<Tweet> tweetList, String filename)
			throws IOException {
		tweetsExporter.addTweetsToFile(tweetList, filename);
	}
}
