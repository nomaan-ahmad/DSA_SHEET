package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// https://leetcode.com/problems/max-points-on-a-line/description/

public class MaxPointsOnALine {
    public static void main(String[] args) {
        int[][] points = {
                {1,4},
                {4,1},
                {5,1},
                {6,4},
                {4,1},
                {2,1},
                {1,4}
        };

        System.out.println(maxPoints(points));
    }
    private static class Pair{
        int x;
        int y;
        Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair that = (Pair) o;
            return this.x == that.x && this.y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static int maxPoints(int[][] points) {
        if (points.length == 1) return 1;
        Map<Pair, Integer> olp = new HashMap<>(); //overlapping points frequency

        int res = Integer.MIN_VALUE;
        for (int[] p : points)
            olp.put(new Pair(p[0], p[1]), olp.getOrDefault(new Pair(p[0], p[1]), 0) + 1);

        for (int i = 0; i < points.length; i++) {
            if (olp.get(new Pair(points[i][0], points[i][1])) == -1) continue;
            HashMap<Pair, Integer> slopes = new HashMap<>();
            for (int j = i+1; j < points.length; j++) {
                if (!((points[i][0] == points[j][0]) && (points[i][1] == points[j][1]))) {
                    int del_x = points[j][0] - points[i][0];
                    int del_y = points[j][1] - points[i][1];

                    int gcd = gcd(del_x, del_y);
                    del_y /= gcd;
                    del_x /= gcd;

                    if (del_y < 0) {
                        del_y *= -1;
                        del_x *= -1;
                    }

                    Pair p = new Pair(del_x, del_y);
                    slopes.put(p, slopes.getOrDefault(p, 0) + 1);
                }
            }
            int max = Integer.MIN_VALUE;
            for (int slp : slopes.values()) max = Math.max(max, slp);

            res = Math.max(res, (olp.get(new Pair(points[i][0], points[i][1])) + max));
        }
        return res;
    }

    private static int gcd (int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}
