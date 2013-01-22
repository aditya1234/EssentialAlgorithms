package strings;

public class RansomNote {

	public static void main(String[] args) {
		String note = "this is a ri";
		String letters = "typing extra words so we have a large sample to work through for a computer programming example";
		char[] note_c = note.toCharArray();
		boolean possible = true;
		for (int i = 0; i < note_c.length; i++) {
			if (letters.indexOf(note_c[i]) != -1)
				letters = letters.replaceFirst(String.valueOf(note_c[i]), "_");
			else {
				possible = false;			
				break;
			}
		}
		
		if (possible) {
			System.out.println("Possible");
		} else {
			System.out.println("Not possible");
		}
		
		System.out.println(letters);
	}

}
