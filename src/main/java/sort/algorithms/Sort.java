package main.java.sort.algorithms;

public interface Sort {
	
	/**
	 * method to sort, calculate the execution time 
	 * and print the sorted array and execution time 
	 */
	public default void printSortedArray(int[] array) {
		long startTime = 0;
		long endTime = 0;
		System.out.println();
		String className = this.getClass().getSimpleName();
		System.out.println("Sorting Algorithm: " + className + "\n");
		startTime = System.currentTimeMillis();
		sortArray(array);
		endTime = System.currentTimeMillis();
		System.out.println("\n" + className + " Time for execution: " + (endTime - startTime) + "ms \n");
		System.out.println("**********************************************************************************");
	}
	
	void sortArray(int[] array);
}
