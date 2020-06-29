package main.java.sort.algorithms.impl;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

import main.java.sort.algorithms.Sort;

/**
 * 
 * Class sorts the inserted array according to bubble sort algorithm.
 * 
 * @author megha.soni
 *
 */
public class BubbleSort implements Sort {

	/**
	 * method to sort array using insertion sort
	 */
	@Override
	public void sortArray(int[] array) {
		//swap logic
		BiConsumer<int[], Integer> swapValueIf = (a, j) -> {
			if (a[j] > a[j + 1]) {
				int temp = a[j];
				a[j] = a[j + 1];
				a[j + 1] = temp;
			}
		};

		// Array Processing
		IntStream.range(0, array.length - 1).forEach(i -> {
			IntStream.range(0, array.length - 1).forEach(j -> swapValueIf.accept(array, j));
			System.out.printf("Pass %d : %s %n", i + 1, Arrays.toString(array));
		});
	}

}
