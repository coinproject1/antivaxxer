package vaccination_analysis.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vaccination_analysis.models.ExcelExport;
import vaccination_analysis.models.Twitterer;

public class ExcelExportFactory {

	FrequencyService fs = new FrequencyService();

	// returns a Hashmap with username + variables
	public List<ExcelExport> getExcelExports(List<Twitterer> twittererList) {

		if (twittererList == null) {
			System.out.println("twitterer-list is null");
		}

		List<ExcelExport> result = new ArrayList<ExcelExport>();
		Iterator<Twitterer> iter = twittererList.iterator();

		while (iter.hasNext()) {

			Twitterer twitterer = iter.next();
			if (iter == null) {
				System.out.println("twitterer-list object is null");
			}
			result.add(getExcelExport(twitterer));

		}
		return result;
	}

	private ExcelExport getExcelExport(Twitterer t) {

		float[] f = fs.getResultArray(t);
		return new ExcelExport(t.getUsername(), t.isAntivaxxer(),
				t.getFriends(), t.getFollowers(),
				t.meanNumberOfMentionsInTweet(),
				t.meanNumberOfHashtagsInTweet(), t.meanNumberOfUrlsInTweet(),
				t.meanTextLength(), t.messagesPosted(),
				t.numberOfDaysOnTwitter(), t.numberOfMessagesFavorited(), f[0],
				f[1], f[2], f[3], f[4], f[5], f[6], f[7], f[8], f[9], f[10],
				f[11], f[12], f[13], f[14], f[15], f[16], f[18], f[19], f[20]);
	}

}
