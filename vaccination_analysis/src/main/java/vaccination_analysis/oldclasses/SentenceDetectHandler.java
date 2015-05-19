package vaccination_analysis.oldclasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException;

public class SentenceDetectHandler {

	public static String[] SentenceDetect(String paragraph) throws InvalidFormatException,
			IOException {
		

		// always start with a model, a model is learned from training data
		InputStream is = new FileInputStream(
				"src/main/resources/OpenNLPModels/en-sent.bin");
		SentenceModel model = new SentenceModel(is);
		SentenceDetectorME sdetector = new SentenceDetectorME(model);

		String sentences[] = sdetector.sentDetect(paragraph);

		is.close();
		return sentences;
	}
}
