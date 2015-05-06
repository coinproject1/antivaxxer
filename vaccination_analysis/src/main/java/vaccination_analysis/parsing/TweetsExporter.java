package vaccination_analysis.parsing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import vaccination_analysis.models.Tweet;

public class TweetsExporter {
	
	private static final File antitweets = new File(
			"src/main/resources/TwittererTextFiles/antitweets.txt");
	private static final File protweets = new File(
			"src/main/resources/TwittererTextFiles/protweets.txt");
	
	public void writeFileFromTweetsList(List<Tweet> tweetList, String filename) throws IOException {
		
		File fout = new File(filename);
		FileOutputStream fos = new FileOutputStream(fout);
		 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
		
		Iterator<Tweet> iter = tweetList.iterator();
		while (iter.hasNext()) {
			
			bw.write(iter.next().toString());
			bw.newLine();
		}
	 
		bw.close();
		
	}

	public void addTweetsToFile(List<Tweet> tweetList, String filename) throws IOException {

	      if ((filename == "protweets.txt" && !protweets.exists()) || (filename == "antitweets.txt" && !antitweets.exists())) {
	    	  writeFileFromTweetsList(tweetList, filename);
	      }
	      
	      else {
	    	  		 
	  		BufferedWriter output = new BufferedWriter(new FileWriter(filename, true));
	  	 
	  		
	  		Iterator<Tweet> iter = tweetList.iterator();
	  		while (iter.hasNext()) {
	  			
	  			output.append(iter.next().toString());
	  			output.newLine();
	  		}
	  	 
	  		output.close();
	    	  
	      }
		
	}

	public void addTweetToFiles(String message, String filename) throws IOException {
		
		String relative_filename = "src/main/resources/TwittererTextFiles/" + filename;
		BufferedWriter output = new BufferedWriter(new FileWriter(relative_filename, true));
		output.append(message);
  		output.newLine();
  		output.close();
		
	}

}
