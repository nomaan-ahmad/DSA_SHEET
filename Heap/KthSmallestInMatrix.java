import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class KthSmallestInMatrix {
    private static class Pair{
        int x;
        int y;
        Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }

        @Override
        public String toString() {
            return "(" + x + ',' +  y + ")";
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };

        System.out.println(kthSmallest(mat, 5));
    }
    public static int kthSmallest(int[][] mat, int k) {
        final int n = mat.length;
        final int m = mat[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                Comparator.comparingInt(p -> mat[p.x][p.y])
        );

        for (int i = 0; i < m; i++) pq.add(new Pair(0,i));

        Pair temp = null;
        while (k-- > 0 && !pq.isEmpty()) {
            temp = pq.poll();

            if (temp.x + 1 < n ) pq.offer(new Pair(temp.x + 1, temp.y));
        }

        return mat[temp.x][temp.y];
    }
}
