import java.util.ArrayList;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

/* We are solving this problem using Priority queue and k-pointer */
public class MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };

        System.out.println(mergeKArrays(arr, arr.length));
    }
    private static class Pair {
        int x;
        int y;

        Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + ']';
        }
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        ArrayList<Integer> res = new ArrayList<>();

        // if k == 1 means only 1 element is there and only 1 row is present
        if (K == 1) {
            res.add(arr[0][0]);
            return res;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair o1,Pair o2) -> arr[o1.x][o1.y] > arr[o2.x][o2.y] ? 1 : -1);

        for (int i = 0; i < K; i++)
            pq.add(new Pair(i, 0));

        while (!pq.isEmpty()) {
            // popping smallest element
            Pair temp = pq.poll();

            // Adding it to the list
            res.add(arr[temp.x][temp.y]);

            // if next index is valid then push it priority queue
            if (temp.y + 1 < K) pq.add(new Pair(temp.x, temp.y + 1));
        }

        return res;
    }
}
