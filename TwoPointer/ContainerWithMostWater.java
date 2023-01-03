
// https://leetcode.com/problems/container-with-most-water/description/

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int low = 0;
        int high = height.length-1;

        while (low < high) {
            int water = (high-low) * Math.min(height[low], height[high]);
            max = Math.max(max, water);
            if (height[low] > height[high]) high--;
            else low++;
        }

        return max;
    }
}