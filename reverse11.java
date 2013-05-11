package strings;

public class Reverse {

  public static void main(String[] args) {
		//String word = "abcdefghi jklmnopq rstuvwxyz";
		String word = "This is a reversed sentence";
		String reversedSentence;
		int first = 0;
		int last = word.length()-1;
		
		reversedSentence = reverser(first,last,word);
		System.out.println(reversedSentence);
		//teiubASIUA
		//lkjkn
		//The "String" is reversed at this point. Let's try re-ordering the words
		int wordFirst = 0;
		int space;
		
		while ( (space = reversedSentence.indexOf(' ', wordFirst)) != -1 ) {
			String subword = reversedSentence.substring(wordFirst, space);
			System.out.print(reverser(0,subword.length()-1,subword) + " ");
			wordFirst = space + 1;
			
			if (wordFirst == reversedSentence.length())
				break;
		}
		
		//One final time
		int wordLast = reversedSentence.length();
		String subword = reversedSentence.substring(wordFirst, wordLast);
		System.out.print(reverser(0,subword.length()-1,subword) + " ");
	}
	
	
	private static String reverser(int start, int end, String word) {
		char[] word_c = word.toCharArray();
		while ( start < end ) {
			char tmp = word_c[start];
			word_c[start] = word_c[end];
			word_c[end] = tmp;
			start++;
			end--;
		}
		
		return String.valueOf(word_c);
	}

}
