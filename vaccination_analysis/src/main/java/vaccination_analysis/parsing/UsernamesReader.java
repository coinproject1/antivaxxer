package vaccination_analysis.parsing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsernamesReader {

	private static final File antivaxxers = new File(
			"src/main/resources/TwittererTextFiles/antivaxxers.txt");
	private static final File provaxxers = new File(
			"src/main/resources/TwittererTextFiles/provaxxers.txt");

	// returns a list of usernames that are stored in a file
	static public List<String> getUserNamesFromFile(File aFile) {

		// ...checks on aFile are elided
		List<String> result = new ArrayList<String>();

		try {
			// use buffering, reading one line at a time
			// FileReader always assumes default encoding is OK!
			BufferedReader input = new BufferedReader(new FileReader(aFile));
			try {
				String line = null; // not declared within while loop
				/*
				 * readLine is a bit quirky : it returns the content of a line
				 * MINUS the newline. it returns null only for the END of the
				 * stream. it returns an empty String if two newlines appear in
				 * a row.
				 */
				while ((line = input.readLine()) != null) {
					result.add(line);
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return result;
	}

	@SuppressWarnings("static-access")
	public List<String> getAntivaxxers() {
		return this.getUserNamesFromFile(antivaxxers);
	}

	@SuppressWarnings("static-access")
	public List<String> getProvaxxers() {
		return this.getUserNamesFromFile(provaxxers);
	}
}