package Assignment;
import java.util.*;
/*In this program I compare the selection sort and insertion sort
 * 
 * sample time:
 * 
 * Sort method        Size_1000     Size_10000     Size_100000
 *       
 * Selection sort     0.012         0.075          5.787
 * Insertion sort     0.007         0.047          4.442
 * 
 */

public class Unit_1_lab_2 {
	private static final int Array_Size = 100000;
	
	private static Random r = new Random();
	
	private static void insertionSort(int[] A) {
		int itemsSorted; // Number of items that have been sorted so far.

        // Assume that items A[0], A[1], ... A[itemsSorted-1] 
        // have already been sorted.  Insert A[itemsSorted]
        // into the sorted part of the list.
	    for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) {
	         
	        int temp = A[itemsSorted];  // The item to be inserted.
	        int loc = itemsSorted - 1;  // Start at end of list.
	      
	        while (loc >= 0 && A[loc] > temp) {
	           A[loc + 1] = A[loc]; // Bump item from A[loc] up to loc+1.
	           loc = loc - 1;       // Go on to next location.
	        }
	        
	        A[loc + 1] = temp; // Put temp in last vacated space.
	    }
	}
	
	private static void selectionSort(int[] A) {
		   
        // Find the largest item among A[0], A[1], ...,
        // A[lastPlace], and move it into position lastPlace 
        // by swapping it with the number that is currently 
        // in position lastPlace.
	    for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
	         
	        int maxLoc = 0;  // Location of largest item seen so far.
	      
	        for (int j = 1; j <= lastPlace; j++) {
	            if (A[j] > A[maxLoc]) {
	                // Since A[j] is bigger than the maximum we've seen
	                // so far, j is the new location of the maximum value
	                // we've seen so far.
	                maxLoc = j;  
	            }
	        }
	      
	        int temp = A[maxLoc];  // Swap largest item with A[lastPlace].
	        A[maxLoc] = A[lastPlace];
	        A[lastPlace] = temp;
	      
	    }  // end of for loop
	   
	}
	
	public static void main(String[] args) {
		int[] array = new int[Array_Size];
		for(int i = 0; i < array.length; i++) {
			array[i]=r.nextInt((int) (Integer.MAX_VALUE*Math.random()));
		}
		
		int[] ArrayCopy1 = Arrays.copyOf(array, array.length);
		
		long startTime = System.currentTimeMillis();
		insertionSort(array);
		long runTime = System.currentTimeMillis() - startTime;
		System.out.println("Insertion sort run time: " + runTime/1000.0);
		
		startTime = System.currentTimeMillis();
		selectionSort(ArrayCopy1);
		runTime = System.currentTimeMillis() - startTime;
		System.out.println("Selection sort run time: " + runTime/1000.0);
		
		
		
	}

}
