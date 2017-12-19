/**
 * 
 */
package com.fourcircles.wordfrequency.test;

import static org.junit.Assert.fail;

import java.util.Hashtable;
import java.util.TreeMap;

import junit.framework.Assert;

import org.junit.Test;

import com.fourcircles.wordfrequency.CountWords;

/**
 * @author Rajeev Kuruganti
 * copyright: 4 Circles LLC
 * 
 *
 */
public class CountWordsTest {
  private CountWords countWords = new CountWords();
  private StringBuffer bufferTest = new StringBuffer("Charity today is meaningless. We need more people not giving in cash or kind. These are" +
  		"material things and they do give the neccisities in life. However, do we give anything to others in our lives. ");
	
		  /**
	 * 
	 * Test method for {@link com.fourcircles.wordfrequency.CountWords#CountWords()}.
	 */
	
	/**
	 * Test method for {@link com.fourcircles.wordfrequency.CountWords#howManyWords(java.io.FileReader)}.
	 */
	@Test
	public void testHowManyWordsFileReader() {
		//TODO FILEINPUT test. 
	}

	/**
	 * Test method for {@link com.fourcircles.wordfrequency.CountWords#howManyWords(java.lang.StringBuffer, boolean)}.
	 */
	@Test
	public void testHowManyWordsStringBufferBoolean() {
	   Hashtable hashmap=	countWords.howManyWords(bufferTest, true);
	   Assert.assertEquals(hashmap.size(),31);
	 
	   Assert.assertEquals(hashmap.get("we"),2);
	}

	/**
	 * Test method for {@link com.fourcircles.wordfrequency.CountWords#howManyWordsSorted(java.lang.StringBuffer, boolean)}.
	 */
	@Test
	public void testHowManyWordsSorted() {
     TreeMap myTree=
		countWords.howManyWordsSorted(bufferTest, false);
     Assert.assertEquals(myTree.size(),32);
	 
	   Assert.assertEquals(myTree.get("Charity"),1);
    
	}

	/**
	 * Test method for {@link com.fourcircles.wordfrequency.CountWords#getWord(java.lang.String)}.
	 */
	@Test
	public void testGetWord() {
		
		String word = countWords.getWord("they don't give the things do they?");
		Assert.assertEquals("they", word);
	//	fail("Not yet implemented"); // TODO
	}

}
