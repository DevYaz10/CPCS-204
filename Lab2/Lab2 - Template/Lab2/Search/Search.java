// Search.java
// Author: 
// Last modified: 
// Program to demonstrate linear vs binary search

package search;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Search {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[100000000];
		init(array);

		// choice: the user choice from the menu
		// value: the value the user wants to search for
		// foundIndex: the value returned from either search method, indicating where
		// the value was found in the array
		int choice, value, foundIndex;
		long startTime, stopTime, totalTime;

		do {
			showMenu();
			choice = input.nextInt();
			if (choice == 1) {
				// Prompt user to enter a value to be searched
				// Perform Linear Search and save the return value
				// Using the returned value, print an appropriate message:
				// - such as the value was found at this index
				// - or the value was not found in the array
				// If you want to get fancy, use a timer (System.nanoTime) to check
				// how long the search takes.
				// *Hint: you need to get the time immediately before the search
				// and then immediately after the search.

				System.out.println("> Please enter a value to search for (between 0 and 100 million): ");
				value = input.nextInt();

				startTime = System.nanoTime();
				foundIndex = linearSearch(array, value);
				stopTime = System.nanoTime();
				totalTime = stopTime - startTime;

				if (foundIndex != -1) {
					System.out
							.println("> The value, " + value + " was found at index " + foundIndex + " in the array.");
				} else {
					System.out.println("> The value " + value + " was not found in the array.");
				}

				System.out.println("> The search took " + totalTime + " nanoseconds to complete ("
						+ TimeUnit.NANOSECONDS.toMillis(totalTime) + " milliseconds).");

			} else if (choice == 2) {
				// Prompt user to enter a value
				// Perform Binary Search and save the return value
				// Using the returned value, print an appropriate message:
				// - such as the value was found at this index
				// - or the value was not found in the array
				// If you want to get fancy, use a timer (System.nanoTime) to check
				// how long the search takes.
				// *Hint: you need to get the time immediately before the search
				// and then immediately after the search.

				System.out.println("> Please enter a value to search for (between 0 and 100 million): ");
				value = input.nextInt();

				startTime = System.nanoTime();
				foundIndex = binarySearch(array, value);
				stopTime = System.nanoTime();
				totalTime = stopTime - startTime;

				if (foundIndex != -1) {
					System.out
							.println("> The value, " + value + " was found at index " + foundIndex + " in the array.");
				} else {
					System.out.println("> The value " + value + " was not found in the array.");
				}

				System.out.println("> The search took " + totalTime + " nanoseconds to complete ("
						+ TimeUnit.NANOSECONDS.toMillis(totalTime) + " milliseconds).");

			} else if (choice == 3) {
				System.out.println();
				System.out.println(" > Exiting...");
				System.out.println(" > Goodbye");
			} else {
				System.out.println();
				System.out.println(" > Invalid choice entered! Please try again.");
				System.out.println();
			}
		} while (choice != 3);
	}

	// Method to show the main menu
	public static void showMenu() {
		System.out.println("****************************************");
		System.out.println("************ Search Menu ***************");
		System.out.println("****************************************");
		System.out.println(" | 1. Linear Search                   |");
		System.out.println(" | 2. Binary Search                   |");
		System.out.println(" | 3. Exit the program                |");
		System.out.println(" --------------------------------------");
		System.out.println();
		System.out.print(" > Enter your choice:  ");
	}

	// Method to initialize the array with random values
	public static void init(int[] array) {
		Random randNum = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = randNum.nextInt(100000000);
		}
		// Now we must sort the array in order to use Binary Search
		Arrays.sort(array);
	}

	// Method to perform Linear Search
	// - Parameters:
	// 1. int[] array, representing array of values
	// 2. int key, representing the value we are searching for
	// - Return type: int, representing the index where the value was found
	//
	public static int linearSearch(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (key == array[i])
				return i; // If found, return index of that element

		}
		return -1; // if not found, return -1 }
	}

	// Method to perform Binary Search
	// - Parameters:
	// 1. int[] array, representing array of values
	// 2. int key, representing the value we are searching for
	// - Return type: int, representing the index where the value was found
	//
	public static int binarySearch(int[] array, int key) {
		int low = 0, high = array.length - 1, mid = 0;
		while (low <= high) {
			mid = (low + high) / 2; // low = 0 high = 9 mid = 4
			if (key == array[mid])
				return mid;
			else if (key < array[mid]) // change high
				high = mid - 1;
			else // change low
				low = mid + 1;
		}
		return -1; // if key not found above
	}

}