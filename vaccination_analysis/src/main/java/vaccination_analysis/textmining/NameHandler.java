package vaccination_analysis.textmining;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

public class NameHandler {

	public Span[] findName(String[] name) throws IOException {
		InputStream is = new FileInputStream(
				"src/main/resources/OpenNLPModels/en-ner-person.bin");

		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		NameFinderME nameFinder = new NameFinderME(model);

		Span nameSpans[] = nameFinder.find(name);

		for (Span s : nameSpans)
			System.out.println(s.toString());
		return nameSpans;
	}

}
