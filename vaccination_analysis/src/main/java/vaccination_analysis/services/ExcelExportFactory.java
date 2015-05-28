package vaccination_analysis.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vaccination_analysis.models.ExcelExport;
import vaccination_analysis.models.Twitterer;
import vaccination_analysis.models.WordFrequencies;

public class ExcelExportFactory {


	// returns a Hashmap with username + variables
	public List<ExcelExport> getExcelExports(List<Twitterer> twittererList) {

		if (twittererList == null) {
			System.out.println("twitterer-list is null");
		}
		List<ExcelExport> result = new ArrayList<ExcelExport>();
		Iterator<Twitterer> iter = twittererList.iterator();

		while (iter.hasNext()) {

			Twitterer twitterer = iter.next();
			result.add(getExcelExport(twitterer));
			System.out.println(twitterer.getUsername()
					+ " as ExcelExport created");

		}
		return result;
	}

	private ExcelExport getExcelExport(Twitterer t) {

		ExcelExport export =  new ExcelExport(t.getUserId(), t.getUsername(),
				t.isAntivaxxer(), t.getFriends(), t.getFollowers(),
				t.meanNumberOfMentionsInTweet(),
				t.meanNumberOfHashtagsInTweet(), t.meanNumberOfUrlsInTweet(),
				t.meanTextLength(), t.messagesPosted(),
				t.numberOfDaysOnTwitter(), t.numberOfMessagesFavorited());
		WordFrequencies wf = new WordFrequencies(t.getTweets());
		export.setFrequency_A(wf.getFrequency_A());
		export.setFrequency_And(wf.getFrequency_And());
		export.setFrequency_But(wf.getFrequency_But());
		export.setFrequency_For(wf.getFrequency_For());
		export.setFrequency_Have(wf.getFrequency_Have());
		export.setFrequency_He(wf.getFrequency_He());
		export.setFrequency_I(wf.getFrequency_I());
		export.setFrequency_In(wf.getFrequency_In());
		export.setFrequency_Is(wf.getFrequency_Is());
		export.setFrequency_It(wf.getFrequency_It());
		export.setFrequency_Me(wf.getFrequency_Me());
		export.setFrequency_My(wf.getFrequency_My());
		export.setFrequency_Of(wf.getFrequency_Of());
		export.setFrequency_On(wf.getFrequency_On());
		export.setFrequency_That(wf.getFrequency_That());
		export.setFrequency_The(wf.getFrequency_The());
		export.setFrequency_To(wf.getFrequency_To());
		export.setFrequency_Was(wf.getFrequency_Was());
		export.setFrequency_With(wf.getFrequency_With());
		export.setFrequency_You(wf.getFrequency_You());
		
		return export;
	}
	

}
