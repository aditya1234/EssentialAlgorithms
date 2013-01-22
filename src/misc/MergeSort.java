package misc;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

	private static int inversions;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] unsorted = {5, 2, 15, 13, 7, 9, 10, -4, 4, 1, 0, -6}; //49
		inversions = 0;
		List<Integer> unsortedObj = new ArrayList<Integer>();
		
		for (int i = 0; i < unsorted.length; i++) {
			unsortedObj.add(new Integer(unsorted[i]));
		}
		
		for (Integer i : merge(unsortedObj)) {
			System.out.println(i);
		}
		
		System.out.println("Inversions = " + inversions);
	}
	
	protected static List<Integer> merge(List<Integer> list) {
		
		if (list.size() <= 1) {
			return list;
		}
		
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		
		int middle = list.size() / 2;
		
		for (int i = 0; i < middle; i++) {
			left.add(list.get(i));
		}
		
		for (int i = middle; i < list.size(); i++) {
			right.add(list.get(i));
		}
		
		left = merge(left);
		right = merge(right);
		
		return merge(left, right);
	}
	
	private static List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> list = new ArrayList<Integer>();
		
		while (left.size() > 0 || right.size() > 0) {
			if (left.size() > 0 && right.size() > 0) {
				if (left.get(0) <= right.get(0)) {
					list.add(left.remove(0));
				} else {
					list.add(right.remove(0));
					inversions += left.size();
					//System.out.println("Adding: (" + list.get(list.size()-1) + ") " + left.size());
				}
			} else if (left.size() > 0) {
				list.add(left.remove(0));
			} else if (right.size() > 0) {
				list.add(right.remove(0));
				inversions += left.size();
				//System.out.println("Adding: (" + list.get(list.size()-1) + ") " + left.size());
			}
		}
		
		return list;
	}

}
