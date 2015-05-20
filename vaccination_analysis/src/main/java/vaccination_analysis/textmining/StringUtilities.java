package vaccination_analysis.textmining;

import java.util.Iterator;
import java.util.List;

import vaccination_analysis.models.WordVariable;

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

	public float getFrequency(List<String> tweets, WordVariable wv) {

		switch (wv) {
		case I:
			return this.getFrequencyHelper(tweets, " i ");
		case Is:
			return this.getFrequencyHelper(tweets, " is ");
		case A:
			return this.getFrequencyHelper(tweets, " a ");
		case For:
			return this.getFrequencyHelper(tweets, " for ");
		case You:
			return this.getFrequencyHelper(tweets, " u ")
					+ this.getFrequencyHelper(tweets, " you ");
		case Have:
			return this.getFrequencyHelper(tweets, " have ");
		case What:
			return this.getFrequencyHelper(tweets, " what ");
		case In:
			return this.getFrequencyHelper(tweets, " in ");
		case Of:
			return this.getFrequencyHelper(tweets, " of ");
		case He:
			return this.getFrequencyHelper(tweets, " he ");
		case To:
			return this.getFrequencyHelper(tweets, " to ");
		case The:
			return this.getFrequencyHelper(tweets, " the ");
		case Was:
			return this.getFrequencyHelper(tweets, " was ");
		case And:
			return this.getFrequencyHelper(tweets, " and ");
		case Me:
			return this.getFrequencyHelper(tweets, " me ");
		case With:
			return this.getFrequencyHelper(tweets, " with ")
					+ this.getFrequencyHelper(tweets, " /w ");
		case That:
			return this.getFrequencyHelper(tweets, " that ");
		case But:
			return this.getFrequencyHelper(tweets, " but ");
		case It:
			return this.getFrequencyHelper(tweets, " it ");
		case My:
			return this.getFrequencyHelper(tweets, " my ");
		case On:
			return this.getFrequencyHelper(tweets, " on ");
		default:
			return 0;
		}

	}

	public float getFrequencyHelper(List<String> tweets, String toSearchFor) {
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
			            // if char isn't a letter and there have been letters before,
			            // counter goes up.
			        } else if (!Character.isLetter(s.charAt(i)) && word) {
			            wordCount++;
			            word = false;
			            // last word of String; if it doesn't end with a non letter, it
			            // wouldn't count without this.
			        } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
			            wordCount++;
			        }
			    }
		}
	    return wordCount;
		
	}

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
