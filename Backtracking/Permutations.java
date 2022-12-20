package Backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/description/

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res, nums, 0);
        return res;
    }

    private static void permute(List<List<Integer>> res, int[] num, int currIndex) {
        List<Integer> temp = new ArrayList<>();
        for (int i : num) temp.add(i);
        res.add(temp);

        if (currIndex == num.length-1) return;

        for (int i = currIndex+1; i < num.length; i++) {
            swap(num, currIndex, i);
            permute(res, num, currIndex+1);
            swap(num, currIndex, i);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
