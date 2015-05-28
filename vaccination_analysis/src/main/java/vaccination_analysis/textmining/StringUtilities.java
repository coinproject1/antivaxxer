package vaccination_analysis.textmining;

import java.util.Iterator;
import java.util.List;
public class StringUtilities {

	private List<String> tweets;
	
	public StringUtilities() {
		this.tweets = null;

	}

	public StringUtilities(List<String> tweets) {
		this.tweets = tweets;

	}

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

	// how often does "http://"+5 more chars appear?
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

	public float getFrequencyHelper(String toSearchFor) {
		float result = 0;
		for (String s : tweets) {
			result += getFrequency(s, toSearchFor);
		}
		int stringListlength = getWordCount(tweets);
		if (stringListlength == 0) {
			return -1;
		}
		return (result / stringListlength);
	}

	private int getWordCount(List<String> tweets) {
		Iterator<String> iter = tweets.iterator();
		int wordCount = 0;
		while (iter.hasNext()) {
			String s = iter.next();
			boolean word = false;
			int endOfLine = s.length() - 1;

			for (int i = 0; i < s.length(); i++) {
				// if the char is a letter, word = true.
				if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
					word = true;
					// if char isn't a letter and there have been letters
					// before,
					// counter goes up.
				} else if (!Character.isLetter(s.charAt(i)) && word) {
					wordCount++;
					word = false;
					// last word of String; if it doesn't end with a non letter,
					// it
					// wouldn't count without this.
				} else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
					wordCount++;
				}
			}
		}
		return wordCount;

	}

	@SuppressWarnings("unused")
	private int getStringListLength(List<String> tweets) {
		int result = 0;
		for (String s : tweets) {
			result += s.length();
		}
		return result;
	}

	// how often does one string contain another?
	private int getFrequency(String str, String findStr) {

		str = " " + str + " ";
		int lastIndex = 0;
		int count = 0;
		while ((lastIndex = str.indexOf(findStr, lastIndex)) != -1) {
			count++;
			lastIndex += findStr.length() - 1;
		}
		return count;
	}
}
