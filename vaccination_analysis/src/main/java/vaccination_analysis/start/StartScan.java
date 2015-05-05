package vaccination_analysis.start;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vaccination_analysis.models.Tweet;
import vaccination_analysis.models.Twitterer;
import vaccination_analysis.parsing.UsernamesReader;
import vaccination_analysis.twitterAPI.TwitterHandler;

public class StartScan {

	static UsernamesReader usernamesReader = new UsernamesReader();
	TwitterHandler twitterHandler = new TwitterHandler();
	static List<Twitterer> antivaxxerList = new ArrayList();
	static List<Twitterer> provaxxerList = new ArrayList();
	
	public static void main(String... aArguments) {
		
		//read vaxxers from file
		List<String> antivaxxers = usernamesReader.getAntivaxxers();
		List<String> provaxxers = usernamesReader.getProvaxxers();
		
		//create twitterers from file -> List of Twitterers, anti + pro
		Iterator<String> itr_anti = antivaxxers.iterator();
		Iterator<String> itr_pro = provaxxers.iterator();
		
		while(itr_anti.hasNext()) {
			String twitterername =  itr_anti.next();
			Twitterer twitterer = new Twitterer(twitterername);
			antivaxxerList.add(twitterer);
			System.out.println("twitterer: " + twitterer.getName());
			
		}
		while(itr_pro.hasNext()) {
			String twitterername =  itr_pro.next();
			Twitterer twitterer = new Twitterer(twitterername);
			provaxxerList.add(twitterer);
		}
		
		//get Tweets for every Twitterer
		Iterator<Twitterer> itr_antitw = antivaxxerList.iterator();
		Iterator<Twitterer> itr_protw = provaxxerList.iterator();
		
		while(itr_antitw.hasNext()) {
			Twitterer current = itr_antitw.next();
			List<Tweet> current_users_tweets = getTweetsFromUser(current);
			Iterator<Tweet> itr_current = current_users_tweets.iterator();
			while (itr_current.hasNext()) {
				current.addTweet(itr_current.next());
				System.out.println("message: " + itr_current.next().getMessage());
			}
			
		}
		while(itr_protw.hasNext()) {
			Twitterer current = itr_protw.next();
			List<Tweet> current_users_tweets = getTweetsFromUser(current);
			Iterator<Tweet> itr_current = current_users_tweets.iterator();
			while (itr_current.hasNext()) {
				current.addTweet(itr_current.next());
			}
		}
		
	}
	
	private static List<Tweet> getTweetsFromUser(Twitterer user) {
		return TwitterHandler.getTweetsFromUser(user.getName());
		
	}
}
