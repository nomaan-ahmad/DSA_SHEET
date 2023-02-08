import java.util.*;

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

public class KPairWithSmallestSum {
    public static void main(String[] args) {
        int[] a = {-10001,-10000,-9999, -9998,-9997,9997,9997,9997,9997,9996};
        int[] b = {-10001,-10001,-10000,-10000,-10000,-9997,-9997,9997,9996,9996,9995,9995};
        int k = 20;

        System.out.println(kSmallestPairs(a, b, k));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        final int n = nums1.length;
        final int m = nums2.length;

        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> isVisited = new HashSet<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((List<Integer> u, List<Integer> v) -> {
            long sum1 = nums1[u.get(0)] + nums2[u.get(1)];
            long sum2 = nums1[v.get(0)] + nums2[v.get(1)];

            return sum1 > sum2 ? 1 : -1;
        });

        pq.add(Arrays.asList(0,0));
        isVisited.add(Arrays.asList(0,0));

        while (!pq.isEmpty() && k-- > 0) {
            List<Integer> temp = pq.poll();
            int i = temp.get(0);
            int j = temp.get(1);

            res.add(Arrays.asList(nums1[i], nums2[j]));

            // Considering first potential contender
            if (i + 1 < n && !isVisited.contains(Arrays.asList(i+1, j))) {
                isVisited.add(Arrays.asList(i+1, j));
                pq.add(Arrays.asList(i+1, j));
            }

            // Considering second potential contender
            if (j + 1 < m && !isVisited.contains(Arrays.asList(i, j+1))) {
                isVisited.add(Arrays.asList(i, j+1));
                pq.add(Arrays.asList(i, j+1));
            }
        }
        return res;
    }
}