package main.java.sort.algorithms.impl;

import main.java.sort.algorithms.Sort;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 
 * Class sorts the inserted array according to merge sort algorithm.
 * 
 * @author megha.soni
 *
 */
public class MergeSort implements Sort {

	private int i = 0;

	@Override
	public void sortArray(int[] array) {
		int[] result = mergeSort(array);
		System.out.println("Pass "+ ++i +":" + Arrays.toString(result));
	}

	/**
	 * 
	 * @param items
	 * @return merge sorted array
	 */
	private int[] mergeSort(int[] items) {
		int length = items.length;
		if(length <= 1) return items;
		
		// Dividing the array into two halves
		int[] left = mergeSort(copy(items, 0, length/2));
		int[] right = mergeSort(copy(items, length/2, length));
		
		// Printing each pass
		System.out.println("Pass "+ ++i +":" +Arrays.toString(left)+ " " +Arrays.toString(right));
		return merge(left, right);
	}

	/**
	 * 
	 * @param left
	 * @param right
	 * @return concatenated merged sorted array
	 */
	private int[] merge(int[] left, int[] right) {
		int leftLen = left.length;
		int rightLen = right.length;

		if(leftLen <= 0) return right;
		if(rightLen <= 0) return left;

		if(left[0] <= (right[0]))
			return concatenate(left[0], merge(copy(left, 1, leftLen), right));
		else
			return concatenate(right[0], merge(left, copy(right, 1, rightLen)));
	}

	/**
	 * 
	 * @param arr1
	 * @param arr2
	 * @return concatenated array
	 */
	private final int[] concatenate(int arr1, int[] arr2) {
		return Stream.of(new int[]{arr1}, arr2)
				.flatMapToInt(x -> Arrays.stream(x))
				.toArray();
	}

	private final int[] copy(int[] items, int start, int endExclusive) {
		return Arrays.copyOfRange(items, start, endExclusive);
	}
}
