package main.java.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import main.java.sort.algorithms.Sort;
import main.java.sort.algorithms.impl.BubbleSort;
import main.java.sort.algorithms.impl.InsertionSort;
import main.java.sort.algorithms.impl.MergeSort;
import main.java.sort.algorithms.impl.QuickSort;
import main.java.sort.algorithms.impl.SelectionSort;

public class SortingAlgorithms {

	private final static List<String> inputs = Arrays.asList("Enter array length- ", "Enter start number- ",
			"Enter end number- ");
	private final static int[] number = new int[3];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int j = 0;

		// Checks if the input is int or not
		for (String input : inputs) {
			System.out.println(input);
			while (!sc.hasNextInt()) {
				System.out.println("That's not a number! Enter again!!!");
				sc.next();
			}
			number[j] = sc.nextInt();
			j++;
		}

		sc.close();
		int[] arr = getDynamicArray(number);
		System.out.println("Actual Array: " + Arrays.toString(arr));

		Sort sort;
		sort = new BubbleSort();
		sort.printSortedArray(arr.clone());

		sort = new SelectionSort();
		sort.printSortedArray(arr.clone());

		sort = new InsertionSort();
		sort.printSortedArray(arr.clone());

		sort = new MergeSort();
		sort.printSortedArray(arr.clone());

		sort = new QuickSort();
		sort.printSortedArray(arr.clone());

	}

	private static int[] getDynamicArray(int[] num) {

		if (num[1] > num[2] || num[1] == num[2]) {
			throw new IllegalArgumentException("End number must be greater than Start number");
		}

		return ThreadLocalRandom.current().ints(num[1], num[2] + 1).limit(num[0]).toArray();
	}

}
