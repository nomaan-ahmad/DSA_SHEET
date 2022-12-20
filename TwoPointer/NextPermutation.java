package TwoPointer;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        final int size = nums.length;
        
        int i = size-2;
        boolean flag = false;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            reverse(nums, 0, size-1);
            return;
        }

        for (int j = size-1; j >= 0; j--)
            if (nums[j] > nums[i]) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                break;
            }

        reverse(nums, i+1, size-1);
    }

    private void reverse (int[] nums, int from, int to) {
        while (from < to) {
            int temp = nums[to];
            nums[to--] = nums[from];
            nums[from++] = temp;
        }
    }
}
