package antivaxxers.beans;

import java.io.IOException;

import java.util.List;

import antivaxxers.dbhandling.DbHandler;
import antivaxxers.models.Twitterer;
import antivaxxers.parsing.ParseFile;

public class StartBean {

	DbHandler dbhandler = new DbHandler();
	private static ParseFile parser;

	public void start() throws IOException {

		parseAntivaxxers();
		parseProvaxxers();

		String[] usernamesAnti = (String[]) parser.getAntivaxxers().toArray();
		dbhandler.saveTweetsFromUsers(usernamesAnti, true);

		String[] usernamesPro = (String[]) parser.getProvaxxers().toArray();
		dbhandler.saveTweetsFromUsers(usernamesPro, false);

	}

	private void parseAntivaxxers() throws IOException {
		parser = new ParseFile(
				"src/main/resources/TwittererTextFiles/antivaxxers.txt");
		parser.processAntivaxxersLineByLine();
	}

	private void parseProvaxxers() throws IOException {
		parser = new ParseFile(
				"src/main/resources/TwittererTextFiles/provaxxers.txt");
		parser.processProvaxxersLineByLine();
	}
	
	public List<Twitterer> getAntivaxxers() {
		return this.dbhandler.getAntivaxxers();
	}

	public List<Twitterer> getProvaxxers() {
		return this.dbhandler.getProvaxxers();
	}

}
