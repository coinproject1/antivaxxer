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
	private List<String> antivaxxers = new ArrayList<>();
	private List<String> provaxxers = new ArrayList<>();

	

	public ParseFile(String aFileName) {
		fFilePath = Paths.get(aFileName);
	}

	public void processAntivaxxersLineByLine() throws IOException {
		try (Scanner scanner = new Scanner(fFilePath, ENCODING.name())) {
			while (scanner.hasNextLine()) {
				processLine(scanner.nextLine(), true);
			}
		}
	}

	public void processProvaxxersLineByLine() throws IOException {
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

		if (isAntivaxxer) {
			if (scanner.hasNext()) {
				this.antivaxxers.add(scanner.next());
			} else {
				log("Empty or invalid line. Unable to process.");
			}
		} else {
			if (scanner.hasNext()) {
				this.provaxxers.add(scanner.next());
			} else {
				log("Empty or invalid line. Unable to process.");
			}
		}

	}

	public List<String> getAntivaxxers() {
		return antivaxxers;
	}

	public List<String> getProvaxxers() {
		return provaxxers;
	}

	public static void log(Object aObject) {
		System.out.println(String.valueOf(aObject));
	}
}