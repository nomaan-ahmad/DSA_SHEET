import java.util.Arrays;

// count pairs who difference is equal to k such that i!=j

public class PairDifference {
    public static void main(String[] args) {
        int[] nums = {2,1,1};
        int k = 1;
        System.out.println(countPairs(nums, k));
    }
    private static long countPairs(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return 0;

        Arrays.sort(nums);

        long count = 0;
        int left = 0, right = 1;

        k = Math.abs(k);

        while (right < len) {
            if (nums[right] - nums[left] < k) right++;
            else if (nums[right] - nums[left] > k) {
                left++;
                if (left == right) right++;
            }
            else {
                if (nums[left] == nums[right]) {
                    long temp = 0;
                    while (nums[left] == nums[right]) {
                        temp++;
                        left++;
                    }
                    count += (temp * (temp-1))/2;
                }else {
                    long tempL = 0;
                    int l = nums[left];
                    while (left < len && nums[left] == l) {
                        left++;
                        tempL++;
                    }

                    long tempR = 0;
                    int r = nums[right];
                    while (right < len && nums[right] == r) {
                        right++;
                        tempR++;
                    }

                    count += tempR * tempL;
                }
            }
        }
        return count;
    }
}
