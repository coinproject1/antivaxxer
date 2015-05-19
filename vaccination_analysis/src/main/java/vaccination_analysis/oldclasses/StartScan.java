package vaccination_analysis.oldclasses;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import vaccination_analysis.parsing.TweetsExporter;
import vaccination_analysis.parsing.UsernamesReader;
import vaccination_analysis.twitterAPI.TwitterHandler;

public class StartScan {

	static private UsernamesReader usernamesReader = new UsernamesReader();
	static private TweetsExporter tweetsExporter = new TweetsExporter();

	// List of Strings for Twitterers and Tweets
	static private List<String> antivaxxerList;
	static private List<String> provaxxerList;
	static private List<String> antivaxxerTweets;
	static private List<String> provaxxerTweets;

	public static void main(String... aArguments) throws IOException {
		
		//first create a list of twitter usernames stored in a file
		createTwitteresFromFiles();
		//then receive all tweets from those users and save them to a file
		getTweetsFromTwitterers();

	}

	//
	private static void createTwitteresFromFiles() {

		System.out.println("Starting scan");
		// read vaxxers from file
		List<String> antivaxxers = usernamesReader.getAntivaxxers();
		List<String> provaxxers = usernamesReader.getProvaxxers();	
		Iterator<String> itr_anti = antivaxxers.iterator();
		Iterator<String> itr_pro = provaxxers.iterator();

		//add every antivaxxer to the list of antivaxxers
		while (itr_anti.hasNext()) {
			String twitterername = itr_anti.next();
			antivaxxerList.add(twitterername);
			System.out.println("twitterer anti added: " + twitterername);
		}
		
		//add every provaxxer to the list of provaxxers
		while (itr_pro.hasNext()) {
			String twitterername = itr_pro.next();
			provaxxerList.add(twitterername);
			System.out.println("twitterer pro added: " + twitterername);
		}

	}

	// get Tweets for every Twitterer that were saved in lists
	private static void getTweetsFromTwitterers() throws IOException {

		// used to iterate through the string lists
		Iterator<String> itr_antitw = antivaxxerList.iterator();
		Iterator<String> itr_protw = provaxxerList.iterator();

		// antivaxxers first
		while (itr_antitw.hasNext()) {
			String currentTwitterer = itr_antitw.next();
			antivaxxerTweets = getTweetsFromUser(currentTwitterer);

			// get every tweet from this twitterer
			Iterator<String> itr_currentTwitterersTweets = antivaxxerTweets
					.iterator();
			while (itr_currentTwitterersTweets.hasNext()) {
				String currentTweet = itr_currentTwitterersTweets.next();
				System.out.println("message from " + currentTwitterer + ": "
						+ currentTweet);
				// and add them to the file
				addTweetToFiles(currentTweet, "antitweets.txt");
			}

		}

		// then provaxxers
		while (itr_protw.hasNext()) {
			String currentTwitterer = itr_protw.next();
			provaxxerTweets = getTweetsFromUser(currentTwitterer);

			Iterator<String> itr_currentTwitterersTweets = provaxxerTweets
					.iterator();
			// get every tweet from this twitterer
			while (itr_currentTwitterersTweets.hasNext()) {
				String currentTweet = itr_currentTwitterersTweets.next();
				System.out.println("message from " + currentTwitterer + ": "
						+ currentTweet);
				// and add them to the file
				addTweetToFiles(currentTweet, "protweets.txt");
			}
		}
	}

	// adds a single tweet to a file
	private static void addTweetToFiles(String message, String filename)
			throws IOException {

		tweetsExporter.addTweetToFiles(message, filename);
	}

	// returns a list auf tweets from a certain user
	private static List<String> getTweetsFromUser(String user) {
		return TwitterHandler.getTweetsFromUser(user);

	}
}
