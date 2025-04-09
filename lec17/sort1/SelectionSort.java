package sort1; 

import java.util.Comparator;
import java.util.Arrays; 

public class SelectionSort {

    // Selection sort for an array of integers
    public static void selectionSortArrayInt(int[] a){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (a[j] < a[min]){ 
                    min = j;
                }
            }
            if (i != min){ 
                swap(a, i, min); 
            }
        }
    }

    public static void swap(int[] a, int i, int min) {
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }

    // Selection Sort for any array of ANY reference type 
    // More general than our selection sort with ints above 
    public static void selectionSort(Object[] a, Comparator comparator){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (comparator.compare(a[j],a[min])< 0){ 
                    min = j;
                }
            }
            if (i != min){ 
                swap(a, i, min); 
            }
        }
    }

    public static void swap(Object[] a, int i, int min) {
        Object temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    } 


    public static void main(String[] args) {
        // // For the simple array of integers case 
        // int[] arr1 = {11, 25, 12, 22}; 
        // System.out.println(Arrays.toString(arr1)); 
        // selectionSortArrayInt(arr1); 
        // System.out.println(Arrays.toString(arr1));

        Integer[] arr = {11, 25, 12, 22};
        System.out.println(Arrays.toString(arr));      
        selectionSort(arr, new IntComparator());
        System.out.println(Arrays.toString(arr));    
    }
}

// // Compares integers in the natural order 
class IntComparator implements Comparator<Integer>{
    
    public int compare(Integer number1, Integer number2){
            if (number1 > number2) return 1;
            if (number1 < number2) return -1;
            return 0;
        }
}

