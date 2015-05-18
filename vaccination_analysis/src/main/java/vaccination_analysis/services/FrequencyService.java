package vaccination_analysis.services;

import java.util.List;

import vaccination_analysis.models.Antivaxxer;
import vaccination_analysis.models.Provaxxer;

public class FrequencyService {

	float[] result = new float[20];
	StringUtilities su = new StringUtilities();

	public float[] getResultArray(Provaxxer t) {
		List<String> tweets = t.getTweets();
		result[0] = su.getFrequency(tweets, "I");
		result[1] = su.getFrequency(tweets, "The");
		result[2] = su.getFrequency(tweets, "And");
		result[3] = su.getFrequency(tweets, "To");
		result[4] = su.getFrequency(tweets, "A");
		result[5] = su.getFrequency(tweets, "Of");
		result[6] = su.getFrequency(tweets, "That");
		result[7] = su.getFrequency(tweets, "In");
		result[8] = su.getFrequency(tweets, "It");
		result[9] = su.getFrequency(tweets, "My");
		result[10] = su.getFrequency(tweets, "Is");
		result[11] = su.getFrequency(tweets, "You");
		result[12] = su.getFrequency(tweets, "Was");
		result[13] = su.getFrequency(tweets, "For");
		result[14] = su.getFrequency(tweets, "Have");
		result[15] = su.getFrequency(tweets, "With");
		result[16] = su.getFrequency(tweets, "He");
		result[17] = su.getFrequency(tweets, "Me");
		result[18] = su.getFrequency(tweets, "On");
		result[19] = su.getFrequency(tweets, "But");
		return result;

	}

	public float[] getResultArray(Antivaxxer t) {
		List<String> tweets = t.getTweets();
		result[0] = su.getFrequency(tweets, "I");
		result[1] = su.getFrequency(tweets, "The");
		result[2] = su.getFrequency(tweets, "And");
		result[3] = su.getFrequency(tweets, "To");
		result[4] = su.getFrequency(tweets, "A");
		result[5] = su.getFrequency(tweets, "Of");
		result[6] = su.getFrequency(tweets, "That");
		result[7] = su.getFrequency(tweets, "In");
		result[8] = su.getFrequency(tweets, "It");
		result[9] = su.getFrequency(tweets, "My");
		result[10] = su.getFrequency(tweets, "Is");
		result[11] = su.getFrequency(tweets, "You");
		result[12] = su.getFrequency(tweets, "Was");
		result[13] = su.getFrequency(tweets, "For");
		result[14] = su.getFrequency(tweets, "Have");
		result[15] = su.getFrequency(tweets, "With");
		result[16] = su.getFrequency(tweets, "He");
		result[17] = su.getFrequency(tweets, "Me");
		result[18] = su.getFrequency(tweets, "On");
		result[19] = su.getFrequency(tweets, "But");
		return result;
	}
}
