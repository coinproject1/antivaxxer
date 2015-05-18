package vaccination_analysis.parsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	
	//Twitter attributes index
	private static final int TWITTER_ID_IDX = 0;
	private static final int TWITTER_FNAME_IDX = 1;
	private static final int TWITTER_LNAME_IDX = 2;
	private static final int TWITTER_MSG = 3; 
	private static final int BLA = 4;
		
	public static void readCsvFile(String fileName) {

		BufferedReader fileReader = null;
     
        try {
        	
        	//Create a new list of Twitteruser to be filled by CSV file data 
        	List twitterList = new ArrayList();
        	
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));
            
            //Read the CSV file header to skip it
            fileReader.readLine();
            
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                	//Create a new twitter object and fill his  data
                	//twitteruser user = new twitteruser(..);
                	//twitterList.add(twitteruser);
				}
            }
            
            //Print the new  list
            //for (... : ...) {
			//	System.out.println(....toString());
			//}
        } 
        catch (Exception e) {
        	System.out.println("Error in CsvFileReader");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader");
                e.printStackTrace();
            }
        }

	}

		
}
