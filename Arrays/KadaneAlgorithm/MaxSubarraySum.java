package KadaneAlgorithm;

// https://leetcode.com/problems/maximum-subarray/description/
public class MaxSubarraySum {

    // my two pointer approach
    public int twoPointer(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        int i = 0;
        int j = 0;
        int sum = nums[0];
        while (j < nums.length) {
            max = Math.max(sum, max);
            if (sum < 0) {
                if (i == j) {
                    i++;
                    j++;
                    if (j < nums.length) sum = nums[j];
                }else {
                    sum -= nums[i];
                    i++;
                }
            }else {
                j++;
                if (j < nums.length) sum += nums[j];
            }
        }   
        return max;
    }


    // solution using Kadane's algorithm
    public int kadane(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currMax = 0;

        for (int i = 0; i < arr.length; i++) {
            currMax = Math.max(currMax + arr[i], arr[i]);
            maxSum = Math.max(currMax, maxSum);
        }

        return maxSum;
    }
}
