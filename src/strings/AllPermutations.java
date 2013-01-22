package strings;

public class AllPermutations {

	public static void main (String args[]) {
		String word = "this";
		permute(new StringBuffer(), word.toCharArray(), word.toCharArray().length, 0, new boolean[word.toCharArray().length]);
	}
	
	private static void permute(StringBuffer perms, char[] letters, int length, int stage, boolean[] used) {
		if (stage != length) {
			for (int i = 0; i < length; i++) {
				if (used[i])
					continue;
				
				perms.append(letters[i]);
				used[i] = true;				
				permute(perms, letters, length, stage+1, used);				
				used[i] = false;
				perms.setLength( perms.length() - 1);
			}
		} else {
			System.out.print(perms.toString() + (perms.toString().equals("shit") ? " lol" : "") + "\n");
		}
	}
}
