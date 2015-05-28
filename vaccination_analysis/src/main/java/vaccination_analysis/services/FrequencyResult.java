package vaccination_analysis.services;

import java.util.List;

import vaccination_analysis.models.Twitterer;
import vaccination_analysis.models.WordFrequencies;
import vaccination_analysis.textmining.StringUtilities;

public class FrequencyResult {

	StringUtilities su = new StringUtilities();

	public WordFrequencies getFrequencies(Twitterer t) {
		
		List<String> tweets = t.getTweets();
		return new WordFrequencies(tweets);

	}

}
