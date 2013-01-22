package strings;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,String> testCases = new HashMap<String,String>();
		testCases.put("yabadabado","abadaba");
		testCases.put("abbad","abba");
		testCases.put("badda","adda");
		testCases.put("abadac","aba");
		testCases.put("cxbada","ada");
		testCases.put("xbbddbbi","bbddbb");
		testCases.put("abcd","b");
		testCases.put("ISAPALINDROMEEMORDNILAPASI","ISAPALINDROMEEMORDNILAPASI");
		testCases.put("badabxxyabadabadoxx","abadaba");
		
		for (String key : testCases.keySet()) {
			String longest = palindrome(key);
			if (longest.equals(testCases.get(key))) {
				System.out.println(key + " : " + longest + " Success!");
			} else {
				System.out.println(key + " : " + longest + " Fail!");
			}
		}
	}
	
	private static String palindrome(String word) {
		char[] word_c = word.toCharArray(); //Treat the word is an array of chars
		int maxIndex = 0;
		int[] lengths = new int[word.length()];
		
		//Scan the word once over. Store
		for (int i = 1; i < word.length(); i++) {
			lengths[i] = 1; // Prep for each iteration: every char is a palindrome of itself
			
			if (word_c[i] == word_c[i-1]) { //Handles the "Even" cases"
				lengths[i] = 2;
			}
			
			/*
			 * First verify our index is not out of bounds
			 * Then check if the character on the far side of the concentric palindrome
			 * is the same. If so our palindrome grows by 2 characters.
			 */
			if (i-1 > 0 && i-lengths[i-1]-1 >= 0 && //Check index bounds
				word_c[i] == word_c[ i - lengths[i - 1] - 1 ]) {
				lengths[i] = lengths[i-1] + 2;
			}
		
			//Maintain what is the longest palindrome
			if (lengths[i] > lengths[maxIndex]) {
				maxIndex = i;
			}
		}
		
		int startIndex = maxIndex - lengths[maxIndex] + 1;
		int endIndex = startIndex + lengths[maxIndex];

		return word.substring(startIndex, endIndex);
	}

}
