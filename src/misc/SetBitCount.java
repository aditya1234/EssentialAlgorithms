package misc;

public class SetBitCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int testValue = 31;
		int bits = 0;
		int mask = 0x01;
		
		while (testValue > 0) {
			bits += testValue & mask;
			testValue >>= 1;
		}
		
		System.out.println("Bits = " + bits);
		
	}

}
