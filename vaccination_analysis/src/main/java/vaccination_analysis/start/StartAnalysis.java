package vaccination_analysis.start;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import vaccination_analysis.models.ExcelExport;
import vaccination_analysis.models.Twitterer;
import vaccination_analysis.parsing.ExcelWriter;
import vaccination_analysis.parsing.UsernamesReader;
import vaccination_analysis.services.ExcelExportFactory;
import vaccination_analysis.twitterAPI.TwitterHandler;

public class StartAnalysis {

	private static List<Twitterer> twitterers = new ArrayList<Twitterer>();
	private static List<ExcelExport> excelExports = new ArrayList<ExcelExport>();
	private static ExcelExportFactory excelExportFactory = new ExcelExportFactory();
	private static UsernamesReader ureader = new UsernamesReader();
	private static TwitterHandler twitterHandler = new TwitterHandler();
	private static ExcelWriter excelWriter = new ExcelWriter();

	public static void main(String... aArguments) throws IOException {

		// first create a list of twitterers stored in a .txt file
		// at src/main/ressources/TwittererTextFiles called
		// antivaxxers.txt provaxxers.txt
		createTwitteresFromFiles();
		// then receive all tweets from those users and save them
		getTweetsFromTwitterers();
		// calculate the variables we need from tweets and twitter infos
		// and store the excelexport that contain the variables in the list
		calculateVariables();
		// export variables for every twitterer in a CVS file
		exportToExcel();
	}

	private static void exportToExcel() {
		System.out.println("exportToExcel called");
		excelWriter.writeFile("vaccination_analysis.xls", excelExports);
		System.out.println("exportToExcel finished");

	}

	private static void calculateVariables() {
		System.out.println("calculateVariables called");
		excelExports.addAll(excelExportFactory.getExcelExports(twitterers));
		System.out.println("calculateVariables finished");

	}

	@SuppressWarnings("static-access")
	private static void getTweetsFromTwitterers() {

		Iterator<Twitterer> twittererIterator = twitterers.iterator();
		while (twittererIterator.hasNext()) {
			Twitterer twitterer = twittererIterator.next();
			twitterer.addTweets(twitterHandler.getTweetsFromUser(twitterer
					.getUsername()));
			System.out.println("############ " + twitterer.toString());

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
			Twitterer antivaxxer = new Twitterer(
					twitterHandler.getUserId(username), username, isAntivaxxer,
					twitterHandler.getFollowers(username),
					twitterHandler.getFriends(username));
			System.out.println("Twitterer: " + username);
			twitterers.add(antivaxxer);
		}

	}

}
