package main.java.sort.algorithms.impl;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

import main.java.sort.algorithms.Sort;

/**
 * 
 * Class sorts the inserted array according to insertion sort algorithm.
 * 
 * @author megha.soni
 *
 */
public class InsertionSort implements Sort {

	/**
	 * method to sort array using insertion sort
	 */
	@Override
	public void sortArray(int[] array) {
		
		// swap logic
		BiConsumer<int[], Integer> swapValueIf = (a, i) -> {
			int key = a[i];
			int j = i - 1;
			/*
			 * Move elements of array[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j = j - 1;
			}
			a[j + 1] = key;
		};

		// Array processing
		IntStream.range(0, array.length).forEach(i -> {
			swapValueIf.accept(array, i);
			System.out.printf("Pass %d : %s %n", i + 1, Arrays.toString(array));
		});
	}

}
