package KadaneAlgorithm;

public class MaximumSumCircularSubarray {
    /*
     *  for explanation, visit : https://leetcode.com/problems/maximum-sum-circular-subarray/solutions/178422/one-pass/?orderBy=most_votes
     */
    // using kadane's algorithm
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int maxSum = Integer.MIN_VALUE;
        int currMax = 0;

        int minSum = Integer.MAX_VALUE;
        int currMin = 0;

        for (int num : nums) {
            totalSum += num;
            currMax = Math.max(currMax + num, num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(currMin + num, num);
            minSum = Math.min(currMin, minSum);
        }

        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }
}
