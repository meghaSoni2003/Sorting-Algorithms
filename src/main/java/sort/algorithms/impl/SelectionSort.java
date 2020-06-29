package main.java.sort.algorithms.impl;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

import main.java.sort.algorithms.Sort;

/**
 * 
 * Class sorts the inserted array according to selection sort algorithm.
 * 
 * @author megha.soni
 *
 */
public class SelectionSort implements Sort {

	/**
	 * method to sort array using insertion sort
	 */
	@Override
	public void sortArray(int[] array) {
		
		// swap logic
		BiFunction<int[], Integer, BiConsumer<Integer, Integer>> swapValueIf = (a , i) -> (j, minIndex) -> {
			if (a[j] < a[minIndex]) {
				minIndex = j;
				int temp = a[minIndex];
				a[minIndex] = a[i];
				a[i] = temp;
			}
		};

		// Array processing
		IntStream.range(0, array.length).forEach(i -> {
			int minIndex = i;
			IntStream.range(i, array.length)
					.forEach(j -> swapValueIf.apply(array, i).accept(j, minIndex));
			System.out.printf("Pass %d : %s %n", i + 1, Arrays.toString(array));
		});
	}

}
