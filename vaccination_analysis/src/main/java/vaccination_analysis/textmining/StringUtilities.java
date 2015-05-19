package vaccination_analysis.textmining;


public class StringUtilities {

	public int countCharSequence(String string, char c) {
		int count = 0;
		char[] tempArray = string.toCharArray();

		for (int i = 0; i < tempArray.length; i++) {
			if (tempArray[i] == c) {
				count++;
			}
		}
		return count;
	}

	public int searchForHttp(String string) {
		int count = 0;
		char[] tempArray = string.toCharArray();
		for (int i = 0; i < tempArray.length; i++) {
			if (tempArray[i] == 'h' && tempArray.length >= i + 12) {
				if (tempArray[i + 1] == 't' && tempArray[i + 2] == 't'
						&& tempArray[i + 3] == 'p' && tempArray[i + 4] == ':'
						&& tempArray[i + 6] == '/' && tempArray[i + 6] == '/')
					;
				count += 1;
				i += 12;
			}
		}
		return count;
	}
}
