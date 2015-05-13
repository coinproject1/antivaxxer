package vaccination_analysis.start;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import vaccination_analysis.models.Antivaxxer;
import vaccination_analysis.models.Provaxxer;
import vaccination_analysis.parsing.UsernamesReader;
import vaccination_analysis.twitterAPI.TwitterHandler;

public class CreateTwitterers {

	private static List<Antivaxxer> antivaxxers;
	private static List<Provaxxer> provaxxers;
	private static UsernamesReader ureader = new UsernamesReader();
	private static TwitterHandler twitterHandler = new TwitterHandler();

	public static void main(String... aArguments) throws IOException {

		// first create a list of twitterers stored in a file
		createTwitteresFromFiles();
		// then receive all tweets from those users and save them
		getTweetsFromTwitterers(antivaxxers, provaxxers);
	}

	private static void getTweetsFromTwitterers(List<Antivaxxer> antivaxxers,
			List<Provaxxer> provaxxers) {

		Iterator<Antivaxxer> antivaxxerIterator = antivaxxers.iterator();
		Iterator<Provaxxer> provaxxerIterator = provaxxers.iterator();

		while (antivaxxerIterator.hasNext()) {
			Antivaxxer antivaxxer = antivaxxerIterator.next();
			antivaxxer.AddTweets(twitterHandler.getTweetsFromUser(antivaxxer
					.getUsername()));
		}
		while (provaxxerIterator.hasNext()) {
			Provaxxer provaxxer = provaxxerIterator.next();
			provaxxer.AddTweets(twitterHandler.getTweetsFromUser(provaxxer
					.getUsername()));
		}

	}

	private static void createTwitteresFromFiles() {

		createTwitterers(ureader.getAntivaxxers(), true);
		createTwitterers(ureader.getProvaxxers(), false);
	}

	private static void createTwitterers(List<String> usernames,
			boolean isAntivaxxer) {
		Iterator<String> iter = usernames.iterator();
		while (iter.hasNext()) {
			String username = iter.next();
			if (isAntivaxxer) {
				Antivaxxer antivaxxer = new Antivaxxer(username,
						twitterHandler.getFollowers(username),
						twitterHandler.getFriends(username));
				antivaxxers.add(antivaxxer);
			} else {
				Provaxxer provaxxer = new Provaxxer(username,
						twitterHandler.getFollowers(username),
						twitterHandler.getFriends(username));
				provaxxers.add(provaxxer);
			}
		}

	}

}
