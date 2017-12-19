/*
 * CountWords.java
 *
 * Created on September 15, 2006, 9:48 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.fourcircles.wordfrequency;

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.log4j.Logger;

/**
 * 
 * @author: Rajeev Kuruganti
 * @company: 4 Circles LLC
 */
public class CountWords {

	/** Creates a new instance of CountWords */
	public CountWords() {
	}

	private static final int EOF = -1;
	private static boolean inWord = false;
	private static Logger logger = Logger.getLogger(CountWords.class);
	private int MAXWORDS=500;
	/**
	 * @param args
	 */

	public int howManyWords(FileReader file) {
		int count = 0;

		// change this method to return a vector with keys and values.
		try {
			for (int data = file.read(); data != EOF; data = file.read()) {
				char charx = (char) data;
				if ((inWord) && (Character.isSpace(charx))) {
					// we've come to the end of a word, so count it
					count++;
					inWord = false;
				} else if (!inWord && Character.isLetterOrDigit(charx)) {
					// we've just started a word or number
					inWord = true;
				}
			}

			if (inWord) // count the last word in the file
				count++;
		} catch (IOException ioe) {
			logger.debug("IOException " + ioe.toString());
		}
		return count;
	}

	public Hashtable howManyWords(StringBuffer strBuff, boolean ignoreCase) {
		int countword = 0;
		
		logger.debug("in thee HowManyWords...method ");
		int indexLastword = 0;
		String word = new String();
		String partialStringBuffer = new String();
		partialStringBuffer = strBuff.toString();
		Vector keyWords = new Vector();
		Hashtable allWords = new Hashtable();
		int counter = 0;
		int totalWords = 0;
		Integer freqWord;
		int ifreqWord = 0;
		while (counter < strBuff.length() - 1) {
			indexLastword = partialStringBuffer.indexOf(" ");
			word = getWord(partialStringBuffer);
			if (ignoreCase) {
				word = word.toLowerCase(); // converts all words to lowercase
			}
			if (!allWords.containsKey(word)) {
				// freqWord= Integer.getInteger("1");
				freqWord = Integer.decode("1");
				// allWords.addElement(word);
				keyWords.add(word);
			} else {
				freqWord = (Integer) allWords.get(word);
				ifreqWord = freqWord.intValue() + 1;
				freqWord = Integer.decode("" + ifreqWord);
			}
			allWords.put(word, freqWord);
			countword++;
			if (indexLastword < 0) {
				break;
			}
			partialStringBuffer = partialStringBuffer
					.substring(indexLastword + 1);
			counter = counter + indexLastword;
		}
		
	return allWords;
	}

	public TreeMap howManyWordsSorted(StringBuffer strBuff, boolean ignoreCase) {
		int countword = 0;
		int indexLastword = 0;
		String word = new String();
		String partialStringBuffer = new String();
		partialStringBuffer = strBuff.toString();
		partialStringBuffer.trim();
		logger.debug("in howmany words sorted");
		Vector keyWords = new Vector();
		TreeMap allWords = new TreeMap();
		int counter = 0;
		int totalWords = 0;
		Integer freqWord;
		int ifreqWord = 0;
		logger.debug("inSorted method");
		while (counter < strBuff.length() - 1) {
			indexLastword = partialStringBuffer.indexOf(" ");
			word = getWord(partialStringBuffer);
			if (ignoreCase) {
				word = word.toLowerCase(); // converts all words to lowercase
			}
			if (!allWords.containsKey(word)) {
				freqWord = Integer.decode("1");
				keyWords.add(word);
			} else {
				freqWord = (Integer) allWords.get(word);
				ifreqWord = freqWord.intValue() + 1;
				freqWord = Integer.decode("" + ifreqWord);
			}
			allWords.put(word, freqWord);
			countword++;
			if (indexLastword < 0) {
				break;
			}
			partialStringBuffer = partialStringBuffer
					.substring(indexLastword + 1);
			counter = counter + indexLastword;
		}

		
		logger.debug("total words -" + countword);
		return allWords;
	}

	public String getWord(String aPhrase) {
		int i = aPhrase.indexOf(" ");
		String aWord = new String();
		String[] punctuation = { ",", ".", "'", "\"", "?", "(", ")", ";",
				"...", "!", "- ", "\t" };
		aPhrase = aPhrase.replaceAll("\"", "");
		if (i > -1) {
			aWord = aPhrase.substring(0, i);
		} else {
			aWord = aPhrase.substring(0);
		}
		aWord.trim();
		for (int pi = 0; pi < punctuation.length; pi++) {
			int j = aWord.indexOf(punctuation[pi]);
			if (j > 0) {
				aWord = aWord.substring(0, j);
			}
		}
		return aWord;
	}

}
