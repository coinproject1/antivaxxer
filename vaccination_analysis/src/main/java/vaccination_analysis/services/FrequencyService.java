package vaccination_analysis.services;

import java.util.List;
import vaccination_analysis.models.Twitterer;
import vaccination_analysis.models.WordVariable;
import vaccination_analysis.textmining.StringUtilities;

public class FrequencyService {

	float[] result = new float[20];
	StringUtilities su = new StringUtilities();

	public float[] getResultArray(Twitterer t) {
		List<String> tweets = t.getTweets();
		result[0] = su.getFrequency(tweets, WordVariable.I);
		result[1] = su.getFrequency(tweets, WordVariable.The);
		result[2] = su.getFrequency(tweets, WordVariable.And);
		result[3] = su.getFrequency(tweets, WordVariable.To);
		result[4] = su.getFrequency(tweets, WordVariable.A);
		result[5] = su.getFrequency(tweets, WordVariable.Of);
		result[6] = su.getFrequency(tweets, WordVariable.That);
		result[7] = su.getFrequency(tweets, WordVariable.In);
		result[8] = su.getFrequency(tweets, WordVariable.It);
		result[9] = su.getFrequency(tweets, WordVariable.My);
		result[10] = su.getFrequency(tweets, WordVariable.Is);
		result[11] = su.getFrequency(tweets, WordVariable.You);
		result[12] = su.getFrequency(tweets, WordVariable.Was);
		result[13] = su.getFrequency(tweets, WordVariable.For);
		result[14] = su.getFrequency(tweets, WordVariable.Have);
		result[15] = su.getFrequency(tweets, WordVariable.With);
		result[16] = su.getFrequency(tweets, WordVariable.He);
		result[17] = su.getFrequency(tweets, WordVariable.Me);
		result[18] = su.getFrequency(tweets, WordVariable.On);
		result[19] = su.getFrequency(tweets, WordVariable.But);
		return result;

	}

}
