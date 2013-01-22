package misc;

import java.util.ArrayList;
import java.util.List;

public class CombineArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> one = new ArrayList<Integer>();
		List<Integer> two = new ArrayList<Integer>();

		one.add(new Integer(1));
		one.add(new Integer(3));
		one.add(new Integer(4));
		one.add(new Integer(7));
		one.add(new Integer(9));
		
		two.add(new Integer(2));
		two.add(new Integer(5));
		two.add(new Integer(6));
		two.add(new Integer(8));
		two.add(new Integer(10));
		
		
		List<Integer> three = finalMerge(one,two);
		
		for (Integer i : three) {
			System.out.print(String.valueOf(i) + ", ");
		}
	}
	
	public static List<Integer> finalMerge(List<Integer> left, List<Integer> right) {
	    List<Integer> finalSort = new ArrayList<Integer>();
	    while (!left.isEmpty() && !right.isEmpty()) {
	        if (left.isEmpty()) {
	            finalSort.addAll(right);
	        } else if (right.isEmpty()) {
	            finalSort.addAll(left);
	        } else {
	            if (left.get(0) < right.get(0))
	                finalSort.add(left.remove(0));
	            else
	                finalSort.add(right.remove(0));
	        }
	    }
	   
	    if (!left.isEmpty()) {
            finalSort.addAll(left);
        } else if (!right.isEmpty()) {
            finalSort.addAll(right);
        }
	   
	    return finalSort;
	}

}
