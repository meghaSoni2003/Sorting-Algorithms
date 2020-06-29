package main.java.sort.algorithms.impl;

import java.util.Arrays;
import java.util.stream.Stream;

import main.java.sort.algorithms.Sort;

public class QuickSort implements Sort {

	private int i = 0;

	@Override
	public void sortArray(int[] array) {
		int[] result = quickSort(array);
		System.out.println("Pass " + ++i + ":" + Arrays.toString(result));
	}

	/**
	 * return quick sorted array
	 */
	private int[] quickSort(int[] array) {

		if (array.length <= 1) {
			return array;
		}

		int pivot = array[0]; // choosing the first element as the pivot

		// sortedSmallerArray = quicksort [a | a <- array, a <= pivot]
		int[] sortedSmallerArray = quickSort(Arrays.stream(array).skip(1) // removing pivot
				.filter(i -> i <= pivot) // filter the elements <= pivot
				.toArray()); // convert the stream back to int array

		// sortedBiggerArray = quicksort [a | a <- array, a > pivot]
		int[] sortedBiggerArray = quickSort(Arrays.stream(array).skip(1) // removing pivot
				.filter(i -> i > pivot) // filter the elements > pivot
				.toArray()); // convert the stream back to List

		System.out.println(
				"Pass " + ++i + ":" + Arrays.toString(sortedSmallerArray) + " " + Arrays.toString(sortedBiggerArray));

		// sortedSmallerArray ++ [pivot] ++ sortedBiggerArray
		return concatenate(sortedSmallerArray, pivot, sortedBiggerArray);
	}

	/**
	 * return concatenated array after each sort
	 */
	private final int[] concatenate(int[] arr1, int arr2, int[] arr3) {
		return Stream.of(arr1, new int[] { arr2 }, arr3)
				.flatMapToInt(a -> Arrays.stream(a))
				.toArray();
	}
}
