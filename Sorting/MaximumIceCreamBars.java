// https://leetcode.com/problems/maximum-ice-cream-bars/description/
import java.util.Arrays;

public class MaximumIceCreamBars {
    public static void main(String[] args) {
        int[] arr = {1,6,3,1,2,5};
        System.out.println(maxIceCream(arr, 20));
    }
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        int i = 0;
        while (i < costs.length) {
            if (coins - costs[i] >= 0) {
                coins -= costs[i];
                res++;
                i++;
            }else return res;
        }
        return (i==costs.length) ? res : 0;
    }
}
