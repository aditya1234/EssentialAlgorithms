package misc;

public class atoi {

	public static void main(String[] args) {
		String num = "-1000246";
		int returnVal = atoi(num);
		
		System.out.println(returnVal);
	}
	
	private static int atoi(String input) {
		boolean negative = (input.charAt(0) == '-');		
		int total = 0;
		int index = (negative) ? 1 : 0;
		
		for (; index < input.length(); index++) {
			total *= 10;
			total += input.charAt(index)-48; //ASCII Conversion
		}
		
		total *= (negative) ? -1 : 1;
		
		return total;
		
	}

}
