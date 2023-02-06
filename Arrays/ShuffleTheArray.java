import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shuffle-the-array/description/

/*
 * --------- Great problem to practice logical thinking -----------
 * 
 * My solution will solve this problem irrespective of type of array and max size of each element of array
 * 
 *  Algorithm ---
 *  1. Create a queue (q) and two pointer (i $ j) respectively
 *  2. Initialize i = 0 and j = n
 *  2. Run a loop for j, from n to (2n-1)
 *  3. In each iteration
 *      - Push element at i index in queue
 *      - make pair with {q.head, arr[j]}
 *      - if (i+1) < n then push arr[i+1] in the queue
 *      - now put the pair into (i) and (i+1) place
 *      - increment i += 2 and j++
 * 
 *  Why it worked? I don't know, i looked at the problem and try to find pattern in the problem, it took me 1hr and finally
 *  made this solution which surprisingly worked :)
 */

public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,3,2,1};
        int n = 4;

        System.out.println(Arrays.toString(shuffle(arr, n)));
    }
    public static int[] shuffle(int[] nums, int n) {
        if (n == 1) return nums;

        int i = 0;
        int j = n;

        Queue<Integer> q = new LinkedList<>();

        while (j < 2*n) {
            if (i < n) q.add(nums[i]);

            int x = q.poll();
            int y = nums[j];

            if (i + 1 < n) q.add(nums[i+1]);

            nums[i] = x;
            nums[i+1] = y;

            i += 2;
            j++;
        }

        return nums;
    }
}
