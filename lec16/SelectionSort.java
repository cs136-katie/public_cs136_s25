import java.util.Arrays; 

public class SelectionSort {

    /*
     * Selection sort for an array of integers
     */
    public static void selectionSortArrayInt(int[] a){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (a[j] < a[min]){ min = j;}
            }
            if (i != min){ swap(a, i, min); }
        }
    }

    // Helper method 
    public static void swap(int[] a, int i, int min) {
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }

    public static void main(String[] args) {
        // For the simple array of integers case 
        int[] arr1 = {11, 25, 12, 22}; 
        System.out.println(Arrays.toString(arr1)); 
        selectionSortArrayInt(arr1); 
        System.out.println(Arrays.toString(arr1)); 
    }
}
