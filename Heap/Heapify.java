package Heap;

import java.util.Arrays;

public class Heapify {
    // this is the approach which will create a heap in O(n) time
    // in this approach we'll go bottom to top

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,1,5,6,7,9};
        System.out.println(Arrays.toString(heapify(arr)));
        System.out.println(Arrays.toString(heapifyRecursively(arr)));
    }

    /***************************** iteratively ********************************/
    public static int[] heapify(int[] arr) {
        // we'll start from last non-leaf node. Why? because all leaf nodes individually are heap
        // to get non-leaf node, we just have to find parent of the last node in the array
        // last element arr[n-1], parent : arr[((n-1)-1)/2] -> arr[(n-2)/2]
        // interesting fact about last non-leaf node that non-lead will always at least contain single child
        // and if there is a single child then that child will always be left child
        final int n = arr.length;
        int last = (n-2)/2; // last non-leaf node

        for (int i = last; i >= 0; i--) {
            int j = i;
            while (j <= last) {
                int max = j;
                int left = (j*2)+1;
                int right = (j*2)+2;
                if (arr[left] > arr[max]) max = left;
                if ((right < n) && arr[right] > arr[max]) max = right;

                if (j == max) break;

                // swapping
                int temp = arr[j];
                arr[j] = arr[max];
                arr[max] = temp;

                j = max;
            }
        }

        return arr;
    }

    /**************************** recursively ********************************/

    public static int[] heapifyRecursively(int[] arr) {
        final int n = arr.length;
        int last = (n-2)/2;

        for (int i = last; i >=0; i--) {
            helper(arr, i, last);
        }

        return arr;
    }
    private static void helper(int[] arr, int index, int last) {
        if (index > last) return;

        int left = (index * 2) + 1;
        int right = (index * 2) + 2;

        int max = index;
        if (arr[left] > arr[max]) max = left;
        if ((right < arr.length) && arr[right] > arr[max]) max = right;

        if (max == index) return; // if none of the children is greater than current element is at right place

        // swapping
        int temp = arr[max];
        arr[max] = arr[index];
        arr[index] = temp;

        helper(arr, max, last);
    }
}

