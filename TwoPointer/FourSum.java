import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 4) return res;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int k = target - (nums[i] + nums[j]);
                int low = j+1;
                int high = len-1;
                while (low < high) {
                    int sum = nums[low] + nums[high];
                    if (sum == k) {
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[low]);
                        li.add(nums[high]);
                        res.add(li);
                        if (nums[low] == nums[high]) break;
                        else {
                            int temp = nums[low];
                            while (low < len && nums[low] == temp) low++;
                            temp = nums[high];
                            while (high >= 0 && nums[high] == temp) high--;
                        }
                    }else if (sum < k){
                        int temp = nums[low];
                        while (low < len && nums[low] == temp) low++;
                    }
                    else{
                        int temp = nums[high];
                        while (high >= 0 && nums[high] == temp) high--;
                    }
                }
                int temp = nums[j];
                while (j < len && nums[j] == temp) j++;
            }
            int temp = nums[i];
            while (i < len && nums[i] == temp) i++;
        }
        return res;
    }
}