/*
* Goal of this problem: Search! Does a target value exist 
* anywhere in an array. 
*
* We implement both linear search and binary search. 
*/

public class Search{

	// Linear search, returns the first index 
	// the target is found in the array 
	public static int linearSearch(int[] array, int target){
        for (int i = 0; i < array.length; i++){
            if (array[i] == target){
               return i; // Target found at index i
            }
        }
        return -1; 
    }

    public static int helperBinarySearch(int[] array, int target, int low, int high){
        // Base case 1: target not found
        if(high <= low){
            return -1; 
        }

        int mid = low + (high-low)/2; 

        // Base case 2: Target found at index mid 
        if(array[mid] == target){
            return mid; 
        }

        if(array[mid] < target){
            return helperBinarySearch(array, target, mid+1, high); 
        }
        else{
            return helperBinarySearch(array, target, low, mid-1);
        }
    }

    // Binary search (same input arguments as linearSearch)
    public static int binarySearch(int[] array, int target) {
        return helperBinarySearch(array, target, 0, array.length-1); // 
    }


	public static void main(String[] args){

		// Caveat: We need the array to be SORTED (for binary search to work)!
		int[] numbers = {1, 2, 3, 5, 7, 9, 11};
        int target = 5;

        // Two different methods
        //int result = linearSearch(numbers, target);
        int result = binarySearch(numbers, target);
        

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }

	}

}