import java.util.PriorityQueue;

/* ************** Very Important Problem ***************** */

// https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

public class MinCostToTieRopes {
    public static void main(String[] args) {
        long[] arr = {4, 2, 7, 6, 9};
        System.out.println(minCost(arr, arr.length));
    }

    public static long minCost(long[] arr, int n) {
        if (n == 1) return 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long i : arr)
            pq.add(i);

        long res = 0;

        while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();

            long sum = first + second;
            res += sum;

            pq.add(sum);
        }

        return res;
    }
}