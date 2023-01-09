package Heap;

import java.util.Arrays;

public class BuildMaxHeap {
    // this approach will make heap in O(nlogn) time
    // this is the most basic approach and will make heap in top-to-down approach

    /*
        indexing from 0 :-
        element: arr[i]
        parent: floor(arr[(i-1)/2])
        children: arr[(i*2)+1] and arr[(i*2)+2]
     */
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,1,5,6,7,9};
        System.out.println(Arrays.toString(buildHeap(arr)));
        System.out.println(Arrays.toString(buildRecursively(arr)));
    }
    // here we are building max heap, building min heap will also be same, one condition have to be reversed

    /************************************* Iteratively ***********************************/
    public static int[] buildHeap(int[] arr) {
        int len = arr.length;
        if (len <= 1) return arr;

        // go to each element and check whether its parent is greater than it, if not then swap
        // do it until path from particular element follows heap property
        for (int i = 1; i < len; i++) {
            int j = i;
            while (j > 0 && arr[(j-1)/2] < arr[j]) {
                int temp = arr[j];
                arr[j] = arr[(j-1)/2];
                arr[(j-1)/2] = temp;
                j = (j-1)/2;
            }
        }
        return arr;
    }

    /****************************** Recursively *********************************/

    public static int[] buildRecursively(int[] arr) {
        final int n = arr.length;

        for (int i = 1; i < n; i++) {
            helper(arr, i);
        }
        return arr;
    }

    private static void helper(int[] arr, int index) {
        if (index < 1) return;
        if (arr[index] > arr[(index-1)/2]) {
            int temp = arr[index];
            arr[index] = arr[(index-1)/2];
            arr[(index-1)/2] = temp;

            helper(arr, (index-1)/2);
        }
    }
}

