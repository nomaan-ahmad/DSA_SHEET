
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 3Sum {
    private List<List<Integer>> tripletSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i < len-2) {
            if (nums[i] > 0) break;
            int k = - (nums[i]);
            int l = i+1;
            int r = len-1;

            while (l < r) {
                if (nums[l] + nums[r] == k) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);

                    if (nums[l] == nums[r]) {
                        break;
                    }else {
                        int t = nums[r];
                        while (r > i && t == nums[r]) r--;

                        t = nums[l];
                        while (l < len && t == nums[l]) l++;
                    }
                }else if (nums[l] + nums[r] > k) {
                    int t = nums[r];
                    while (r > i && t == nums[r]) r--;
                }else {
                    int t = nums[l];
                    while (l < len && t == nums[l]) l++;
                }
            }

            int t = nums[i];
            while (i < len && t == nums[i]) i++;
        }

        return res;
    }
}
