import java.util.Arrays;

// Problem is to return count of pairs whose sum is equal to 'K' in a given array

public class PairSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        int k = 2;
        System.out.println(pairSum(nums, k));
    }
    private static long pairSum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return 0;

        Arrays.sort(nums);
        long count = 0;

        int left = 0, right = len-1;

        while (left < right) {
            if (nums[left] + nums[right] > k) right--;
            else if (nums[left] + nums[right] < k) left++;
            else {
                if (nums[left] == nums[right]) {
                    long temp = 0;
                    while (left < len && nums[left] == nums[right]) {
                        temp++;
                        left++;
                    }
                    count += (temp * (temp-1))/2;
                }else{
                    long tempL = 0;
                    int l = nums[left];
                    while (left < len && nums[left] == l) {
                        tempL++;
                        left++;
                    }

                    long tempR = 0;
                    int r = nums[right];
                    while (right >= 0 && nums[right] == r){
                        tempR++;
                        right--;
                    }

                    count += tempR*tempL;
                }
            }
        }
        return count;
    }
}