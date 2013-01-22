package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shuffle {

	public static void main(String[] args) {
		int[] sorted = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};		
		int[] unsorted = shuffle(sorted);
		
		for (int i = 0; i < unsorted.length; i++) {		
			System.out.print(String.valueOf(sorted[i]) + " ");
		}
		System.out.println();
		for (int i = 0; i < unsorted.length; i++) {			
			System.out.print(String.valueOf(unsorted[i]) + " ");
		}
	
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < unsorted.length; i++) {
			list.add(new Integer(unsorted[i]));
		}
		//Try resorting it with my mergesort?
		List<Integer> sortedList = misc.MergeSort.merge(list);
		System.out.println();
		for (int i = 0; i < unsorted.length; i++) {			
			System.out.print(String.valueOf(sortedList.get(i)) + " ");
		}
	}
	
	static int[] shuffle(int[] old_list) {
		Random r = new Random();
		int[] list = old_list.clone();
		
		for (int i = 0; i < list.length; i++) {
			int swapVal = i + r.nextInt((list.length - i));
			int tmp = list[i];
			list[i] = list[swapVal];
			list[swapVal] = tmp;
		}
		
		return list;
		
	}

}
