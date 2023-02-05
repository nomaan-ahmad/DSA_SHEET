import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/heap-sort/1
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {44,19,43,27,55,18,21,88};
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    //Function to build a Heap from array.
    static void buildHeap(int[] arr, int n) {
        int lastNonLeaf = (n-2)/2;

        for (int i = lastNonLeaf; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    //Heapify function to maintain heap property.
    // 'i' parameter is to indicate on which index we have to invoke heapify
    static void heapify(int[] arr, int n, int i) {
        int lastNonLeaf = (n-2)/2;
        if (i > lastNonLeaf || n == 1) return;

        while (i <= lastNonLeaf ) {
            int max = i;

            // left child
            int left = (i*2) + 1;
            if (arr[left] > arr[max]) max = left;

            // right child if exist
            int right = (i*2) + 2;
            if (right < n && arr[right] > arr[max]) max = right;

            // if no child is greater than its parent then we'll just return
            if (max == i) return;

            // swapping
            {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }

            // updating index of i
            i = max;
        }
    }

    //Function to sort an array using Heap Sort.
    public static void heapSort(int[] arr, int n) {
        if (n < 2) return;

        buildHeap(arr, n);

        while (n > 1) {
            // deleting first element and swapping it with last element
            int temp = arr[0];
            arr[0] = arr[n-1];
            arr[n-1] = temp;

            // decrementing the size of heap
            n--;

            // calling heapify for the first index
            heapify(arr, n, 0);
        }
    }
}