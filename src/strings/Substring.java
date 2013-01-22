package strings;

public class Substring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String word = "best";
		String sentence = "bethisistheestwordherebest";
		
		if (substring(word,sentence)) {
			System.out.println("Found it");
		} else {
			System.out.println("Nope, missing");
		}

	}
	
	private static boolean substring(String word, String container) {
		
		char[] word_array = word.toCharArray();
		char[] container_array = container.toCharArray();
		
		boolean found = false;
		
		for (int i = 0; i < container_array.length; i++) {
			found = true;
			for (int j = 0; j < word_array.length; j++) {
				if (container_array[j + i] != word_array[j]) {
					found = false;
					break;
				}
			}
			if (found) {
				break;
			}
		}
		
		return found;
		
	}

}
