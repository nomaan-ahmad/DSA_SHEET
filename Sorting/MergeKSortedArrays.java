import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

// In this approach, we are using the concept of Merge sort - divide and conquer strategy
// In merge sort, we use to keep dividing the array until 1 element left and then start merging it in sorted manner
public class MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println(mergeKArrays(mat, 3));
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        ArrayList<Integer> res = new ArrayList<>();

        // if k == 1 means only 1 element is there and only 1 row is present
        if (K == 1) {
            res.add(arr[0][0]);
            return res;
        }

        return divide(0, K-1, arr);
    }

    // This approach will keep on dividing the matrix into equal halves wrt. row

    // then after dividing we'll merge it
    private static ArrayList<Integer> divide (int start, int end, int[][] arr) {
        if (start == end) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                temp.add(arr[start][i]);

            return temp;
        }

        // calculating mid row
        int mid = start + (end - start)/2;

        // dividing further
        ArrayList<Integer> left = divide(start, mid, arr);
        ArrayList<Integer> right = divide(mid+1, end, arr);

        // finally merging both divided list
        return mergeList(left, right);
    }

    // Merge method to merge two list
    private static ArrayList<Integer> mergeList(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        final int n = l1.size();
        final int m = l2.size();
        ArrayList<Integer> temp = new ArrayList<>();

        int i = 0; // for l1 list
        int j = 0; // for l2 list

        // Filling temp list in sorted manner
        while (i < n && j < m) {
            if (l1.get(i) < l2.get(j)) temp.add(l1.get(i++));
            else temp.add(l2.get(j++));
        }


        // if any element left in l1
        while (i < n) {
            temp.add(l1.get(i++));
        }

        // if any element left in l2
        while (j < m) {
            temp.add(l2.get(j++));
        }

        return temp;
    }
}