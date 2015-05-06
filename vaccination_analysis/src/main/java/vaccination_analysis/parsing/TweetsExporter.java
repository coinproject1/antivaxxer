package vaccination_analysis.parsing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

public class TweetsExporter {

	private static final File antitweets = new File(
			"src/main/resources/TwittererTextFiles/antitweets.txt");
	private static final File protweets = new File(
			"src/main/resources/TwittererTextFiles/protweets.txt");

	//write a file from a list of tweets
	public void writeFileFromTweetsList(List<String> tweetList, String filename)
			throws IOException {

		File fout = new File(filename);
		FileOutputStream fos = new FileOutputStream(fout);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		Iterator<String> iter = tweetList.iterator();
		while (iter.hasNext()) {

			bw.write(iter.next());
			bw.newLine();
		}

		bw.close();

	}

	//add tweets to a file, checks if the filename has to be created or if it adds them to an existing file
	public void addTweetsToFile(List<String> tweetList, String filename)
			throws IOException {

		if ((filename == "protweets.txt" && !protweets.exists())
				|| (filename == "antitweets.txt" && !antitweets.exists())) {
			writeFileFromTweetsList(tweetList, filename);
		}

		else {

			BufferedWriter output = new BufferedWriter(new FileWriter(filename,
					true));

			Iterator<String> iter = tweetList.iterator();
			while (iter.hasNext()) {

				output.append(iter.next());
				output.newLine();
			}

			output.close();

		}

	}

	//add tweets to an existing file depending on the wished filename
	public void addTweetToFiles(String message, String filename)
			throws IOException {

		String relative_filename = "src/main/resources/TwittererTextFiles/"
				+ filename;
		BufferedWriter output = new BufferedWriter(new FileWriter(
				relative_filename, true));
		output.append(message);
		output.newLine();
		output.close();

	}

}
