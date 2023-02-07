// https://leetcode.com/problems/fruit-into-baskets/description/

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(arr));
    }
    public static int totalFruit(int[] fruits) {
        final int n = fruits.length;
        int i = 0;
        int j = 0;

        while (j < n && fruits[j] == fruits[i]) j++;
        if (j == n) return n;

        int max = Integer.MIN_VALUE;

        int basket1 = fruits[i];
        int basket2 = fruits[j];

        while (j < n) {
            if (!(fruits[j] == basket1 || fruits[j] == basket2)) {
                max = Math.max(j-i, max);
                int loop = i;
                while (loop < j) {
                    if (!(fruits[i] == fruits[loop])) i = loop;
                    loop++;
                }
                if (fruits[i] == basket1) basket2 = fruits[j];
                else basket1 = fruits[j];
            }
            j++;
        }

        max = Math.max(max, j-i);
        return max;
    }
}