// https://leetcode.com/problems/non-decreasing-subsequences/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NonDecreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 1) return res;
        if (nums.length == 2) {
            if (nums[0] <= nums[1]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[0]);
                temp.add(nums[1]);

                res.add(temp);
            }
            return res;
        }

        helper(res, new ArrayList<>(), nums, -1);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int lastIndex) {
        if (temp.size() >= 2) {
            // if the array size is 2 then we can add it in the resultant array
            res.add(new ArrayList<>(temp));
        }

        int len = temp.size();

        // hashset to eradicate addition of duplicates in the temp array
        HashSet<Integer> set = new HashSet<>();
        for (int i = lastIndex+1 ; i < nums.length; i++) {
            /*
                If lastIndex == -1 means there is nothing in the temp array
                so whatever we get will be eligible for addition in the temp array
             */
            if ((lastIndex == -1 || nums[i] >= nums[lastIndex]) && !set.contains(nums[i])) {
                set.add(nums[i]);
                temp.add(nums[i]);
                helper(res, temp, nums, i);
                temp.remove(len);
            }
        }
    }
}
