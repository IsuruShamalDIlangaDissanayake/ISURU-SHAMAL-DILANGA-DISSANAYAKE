package Assignment;

import java.util.*;

public class BuggySearchAndSort {
	
	public static void main(String[] args) {
		int[] A = new int[10];
		for (int i = 0; i < 10; i++)
			A[i] = 1 + (int)(10 * Math.random());
		
		int[] B = A.clone();
		int[] C = A.clone();
		int[] D = A.clone();
		
		System.out.print("The array is: ");
		printArray(A);
		
		if (contains(A,5))
			System.out.println("The array DOES contain 5. ");
		else
			System.out.println("The array DOES NOT contain 5. ");
		
		Arrays.sort(A);
		System.out.print("Sorted by Arrays.sort():  ");
		printArray(A);
		
		bubbleSort(B);
		System.out.print("Sorted by bubble Sort:  ");
		printArray(B);
		
		selectionSort(C);
		System.out.print("Sorted by Selection Sort");
		printArray(C);
		
		insertionSort(D);
		System.out.print("Sorted by Insertion Sort: ");
		printArray(D);
	}
	
	public static boolean contains(int[] array, int val) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == val)
				return true;
		}
		return false;
	}
	
	public static void bubbleSort(int[] array) {
		for ( int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-1;j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	public static void selectionSort(int[] array) {
		for (int top = array.length - 1; top > 0; top--) {
			int positionOfMax = 0;
			for (int i = 1; i <= top; i++) {
				if (array[i] > array[positionOfMax])
					positionOfMax = i;
			}
			int temp = array[top];  
			array[top] = array[positionOfMax];
			array[positionOfMax] = temp;
		}
		
	}
	
	public static void insertionSort(int[] array) {
		for (int top = 1; top < array.length; top++) {
			int temp = array[top];  
			int pos = top - 1;
			while (pos >= 0 && array[pos] > temp) {
				  
				array[pos+1] = array[pos];
				pos--;
			}
			array[pos + 1] = temp;  
		}
	}
	
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" ");
			System.out.print(array[i]);
		}
		System.out.println();
	}

}
