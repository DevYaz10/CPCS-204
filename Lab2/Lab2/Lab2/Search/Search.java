// Search.java
// Author:
// Last modified: 
// Program to demonstrate linear vs binary search

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
		int choice; // ! value, foundIndex
		// ! long startTime, stopTime, totalTime;
		// ? These variables are now declared inside the performSearch method, since
		// they are only used there.

		// ! I made some edits to the main method to make it cleaner and easier to read.
		// but in exams you should not edit the pre written code AT ALL.
		do {
			showMenu();
			choice = input.nextInt();

			if (choice == 1 || choice == 2) {
				// * it's much cleaner to have a separate method to perform the search, rather
				// repeating the same code twice in the main method. This is called
				// "refactoring" and is a good programming practice.
				performSearch(choice, input, array);

			} else if (choice == 3) {
				System.out.println();
				System.out.println(" > Exiting...");
				System.out.println(" > Goodbye");
				System.exit(0);

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

	public static void performSearch(int choice, Scanner input, int[] array) {
		// 1. Declare these variables locally inside the method
		int value, foundIndex = -1;
		long startTime, stopTime;

		System.out.print("> Please Enter a value to search for (between 0 and 100 million): ");
		value = input.nextInt();

		startTime = System.nanoTime();

		// 2. Use the user's choice to determine which search to run
		if (choice == 1) {
			foundIndex = linearSearch(array, value);
		} else if (choice == 2) {
			foundIndex = binarySearch(array, value);
		}

		stopTime = System.nanoTime();

		// Calculate the time taken for the search in nanoseconds and milliseconds
		long nanoSeconds = stopTime - startTime;
		long milliSeconds = TimeUnit.MILLISECONDS.convert(nanoSeconds, TimeUnit.NANOSECONDS);

		if (foundIndex == -1) {
			System.out.printf("> The value, %d, was not found in the array\n\n", value);
		} else {
			System.out.printf("> The value, %d, was found at index %d in the array\n\n", value, foundIndex);
		}

		System.out.printf("> This search took %d nanoseconds to complete (or %d milliseconds)\n\n",
				nanoSeconds, milliSeconds);

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

	//? these methods are already implemented in the lab instructions, so i just copied them here. i didn't invent anything new.
	//? but i don't know if it will be provided in the exam or not.

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
		return -1; // if not found, return -1

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
			mid = (low + high) / 2;
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