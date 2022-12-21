
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/
public class Permutations_ii {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res, nums, 0);
        return res;
    }

    private void permute(List<List<Integer>> res, int[] nums, int currIndex) {
        if (currIndex == nums.length-1) {
            List<Integer> temp = new ArrayList<>();
            for (int i : nums) temp.add(i);
            res.add(temp);
            return;
        }

        HashSet<Integer> matched = new HashSet<>();
        for (int i = currIndex; i < nums.length; i++) {
            if (!matched.contains(nums[i])) {
                matched.add(nums[i]);
                swap(nums, i, currIndex);
                permute(res, nums, currIndex);
                swap(nums, i, currIndex);
            }
        }
    }

    private void swap (int[] nums, int index1 , int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

