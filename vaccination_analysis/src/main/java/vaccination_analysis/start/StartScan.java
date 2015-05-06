package vaccination_analysis.start;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vaccination_analysis.parsing.TweetsExporter;
import vaccination_analysis.parsing.UsernamesReader;
import vaccination_analysis.twitterAPI.TwitterHandler;

public class StartScan {

	static private UsernamesReader usernamesReader = new UsernamesReader();
	private TwitterHandler twitterHandler = new TwitterHandler();
	static private List<String> antivaxxerList = new ArrayList();
	static private List<String> provaxxerList = new ArrayList();
	static private TweetsExporter tweetsExporter = new TweetsExporter();
	static private List<String> antivaxxerTweets;
	static private List<String> provaxxerTweets;

	public static void main(String... aArguments) throws IOException {

		getTweetsFromTwitterers();
		createTwitteresFromFiles();
		getTweetsFromTwitterers();

	}

	private static void createTwitteresFromFiles() {

		System.out.println("Starting scan");
		// read vaxxers from file
		List<String> antivaxxers = usernamesReader.getAntivaxxers();
		List<String> provaxxers = usernamesReader.getProvaxxers();

		// create twitterers from file -> List of Twitterers, anti + pro
		Iterator<String> itr_anti = antivaxxers.iterator();
		Iterator<String> itr_pro = provaxxers.iterator();

		while (itr_anti.hasNext()) {
			String twitterername = itr_anti.next();
			antivaxxerList.add(twitterername);
			System.out.println("twitterer anti added: " + twitterername);

		}
		while (itr_pro.hasNext()) {
			String twitterername = itr_pro.next();
			provaxxerList.add(twitterername);
			System.out.println("twitterer pro added: " + twitterername);
		}

	}

	private static void getTweetsFromTwitterers() throws IOException {

		// get Tweets for every Twitterer

		Iterator<String> itr_antitw = antivaxxerList.iterator();
		Iterator<String> itr_protw = provaxxerList.iterator();

		while (itr_antitw.hasNext()) {
			String currentTwitterer = itr_antitw.next();
			antivaxxerTweets = getTweetsFromUser(currentTwitterer);

			Iterator<String> itr_currentTwitterersTweets = antivaxxerTweets
					.iterator();

			while (itr_currentTwitterersTweets.hasNext()) {
				String currentTweet = itr_currentTwitterersTweets.next();
				System.out.println("message from " + currentTwitterer + ": "
						+ currentTweet);
				addTweetToFiles(currentTweet, "antitweets.txt");
			}

		}
		while (itr_protw.hasNext()) {
			String currentTwitterer = itr_protw.next();
			provaxxerTweets = getTweetsFromUser(currentTwitterer);

			Iterator<String> itr_currentTwitterersTweets = provaxxerTweets
					.iterator();

			while (itr_currentTwitterersTweets.hasNext()) {
				String currentTweet = itr_currentTwitterersTweets.next();
				System.out.println("message from " + currentTwitterer + ": "
						+ currentTweet);
				addTweetToFiles(currentTweet, "protweets.txt");
			}
		}
	}

	private static void addTweetToFiles(String message, String filename)
			throws IOException {

		tweetsExporter.addTweetToFiles(message, filename);
	}

	private static List<String> getTweetsFromUser(String user) {
		return TwitterHandler.getTweetsFromUser(user);

	}

	private static void addTweetsToFiles(List<String> tweetList, String filename)
			throws IOException {
		tweetsExporter.addTweetsToFile(tweetList, filename);
	}

	private static void writeTweetsToFiles() throws IOException {
		addTweetsToFiles(antivaxxerTweets, "antitweets.txt");
		addTweetsToFiles(provaxxerTweets, "protweets.txt");

	}
}
