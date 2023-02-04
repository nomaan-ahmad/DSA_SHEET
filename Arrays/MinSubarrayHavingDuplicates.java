import java.util.HashMap;

// https://www.geeksforgeeks.org/find-the-smallest-subarray-having-atleast-one-duplicate/

public class MinSubarrayHavingDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,3,2,3,5,5};
        System.out.println(weird_array(arr, arr.length));
    }

    private static int weird_array(int[] arr, int n) {
        if (n < 2) return 0;

        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;

        // we'll just store last index occurrence of each element
        // and if it occurred again in the future, we'll just find length of that subarray
        while (j < n) {
            if (map.containsKey(arr[j])) {
                int lastPos = map.get(arr[j]);
                if (j - lastPos + 1 >= 2)
                    min = Math.min(min, j - lastPos + 1);
            }
            map.put(arr[j], j);
            j++;
        }

        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
