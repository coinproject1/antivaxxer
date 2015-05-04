package antivaxxers.parsing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import antivaxxers.models.Twitterer;

public class ParseFile {

	// PRIVATE
	private final Path fFilePath;
	private final static Charset ENCODING = StandardCharsets.UTF_8;
	private List<Twitterer> antivaxxers = new ArrayList<>();

	public void parseAntivaxxers() throws IOException {
		ParseFile parser = new ParseFile("src/main/resources/TwittererTextFiles/antivaxxers.txt");
		parser.processAntivaxxersLineByLine();
		log("Done.");
	}
	
	public void parseProvaxxers() throws IOException {
		ParseFile parser = new ParseFile("src/main/resources/TwittererTextFiles/provaxxers.txt");
		parser.processProvaxxersLineByLine();
		log("Done.");
	}

	public ParseFile(String aFileName) {
		fFilePath = Paths.get(aFileName);
	}

	private void processAntivaxxersLineByLine() throws IOException {
		try (Scanner scanner = new Scanner(fFilePath, ENCODING.name())) {
			while (scanner.hasNextLine()) {
				processLine(scanner.nextLine(), true);
			}
		}
	}
	private void processProvaxxersLineByLine() throws IOException {
		try (Scanner scanner = new Scanner(fFilePath, ENCODING.name())) {
			while (scanner.hasNextLine()) {
				processLine(scanner.nextLine(), false);
			}
		}
	}

	protected void processLine(String aLine, boolean isAntivaxxer) {
		// use a second Scanner to parse the content of each line
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter(" ");
		if (scanner.hasNext()) {
			Twitterer twitterer = new Twitterer(scanner.next(), isAntivaxxer);
			this.antivaxxers.add(twitterer);			
		} else {
			log("Empty or invalid line. Unable to process.");
		}
	}

	private static void log(Object aObject) {
		System.out.println(String.valueOf(aObject));
	}
}