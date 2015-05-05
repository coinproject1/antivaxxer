package vaccination_analysis.textmining;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

public class TagPositionHandler {

	public static void tagPosition() throws FileNotFoundException {
		InputStream modelIn = null;
		POSModel model = null;

		try {
		  modelIn = new FileInputStream("src/main/resources/OpenNLPModels/en-pos-maxent.bin");
		  model = new POSModel(modelIn);
		}
		catch (IOException e) {
		  // Model loading failed, handle the error
		  e.printStackTrace();
		}
		finally {
		  if (modelIn != null) {
		    try {
		      modelIn.close();
		    }
		    catch (IOException e) {
		    }
		  }
		}
		@SuppressWarnings("unused")
		POSTaggerME tagger = new POSTaggerME(model);
		
	 
	}
}
