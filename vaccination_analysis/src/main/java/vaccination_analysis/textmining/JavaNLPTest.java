package vaccination_analysis.textmining;

import opennlp.tools.namefind.*;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.*;
import opennlp.tools.tokenize.*;
import opennlp.tools.util.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class JavaNLPTest {

	public static void main(String[] args) throws IOException {

		SentenceDetect();
		tagPosition();
		findName();
		tokenize();

	}

	public static void SentenceDetect() throws InvalidFormatException,
			IOException {
		String paragraph = "Hi. How are you? This is Mike.";

		// always start with a model, a model is learned from training data
		InputStream is = new FileInputStream(
				"src/main/resources/OpenNLPModels/en-sent.bin");
		SentenceModel model = new SentenceModel(is);
		SentenceDetectorME sdetector = new SentenceDetectorME(model);

		String sentences[] = sdetector.sentDetect(paragraph);

		System.out.println(sentences[0]);
		System.out.println(sentences[1]);
		is.close();
	}

	public static void tagPosition() throws FileNotFoundException {
		InputStream modelIn = null;
		POSModel model = null;

		try {
			modelIn = new FileInputStream(
					"src/main/resources/OpenNLPModels/en-pos-maxent.bin");
			model = new POSModel(modelIn);
		} catch (IOException e) {
			// Model loading failed, handle the error
			e.printStackTrace();
		} finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				} catch (IOException e) {
				}
			}
		}
		POSTaggerME tagger = new POSTaggerME(model);
		String sent[] = new String[] { "Most", "large", "cities", "in", "the",
				"EUROPE", "had", "morning", "and", "afternoon", "newspapers",
				".", "US", "europe", "EU" };
		String tags[] = tagger.tag(sent);
		double probs[] = tagger.probs();
		Sequence topSequences[] = tagger.topKSequences(sent);
		for (String a : tags)
			System.out.println(a);

	}

	public static void tokenize() throws InvalidFormatException, IOException {
		InputStream is = new FileInputStream(
				"src/main/resources/OpenNLPModels/en-token.bin");

		TokenizerModel model = new TokenizerModel(is);

		Tokenizer tokenizer = new TokenizerME(model);

		String tokens[] = tokenizer.tokenize("Hi. How are you? This is Mike.");

		for (String a : tokens)
			System.out.println(a);

		is.close();
	}

	public static void findName() throws IOException {
		InputStream is = new FileInputStream(
				"src/main/resources/OpenNLPModels/en-ner-person.bin");

		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		NameFinderME nameFinder = new NameFinderME(model);

		String[] sentence = new String[] { "Mike", "Smith", "is", "a", "good",
				"person" };

		Span nameSpans[] = nameFinder.find(sentence);

		for (Span s : nameSpans)
			System.out.println(s.toString());
	}

}
