package Graph.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/knight-walk4521/1
public class KnightWalk {
    public static void main(String[] args) {
        int n = 6;
        int[] k = {4,5};
        int[] t = {1,1};

        System.out.println(minStepToReachTarget(k,t,n));
    }
    final static int[][] moves = {
            {2,1},
            {2,-1},
            {-2,1},
            {-2,-1},
            {1,2},
            {1,-2},
            {-1,2},
            {-1,-2}
    };

    static int pow;
    public static int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> isVisited = new HashSet<>();
        int d = (int) Math.floor(Math.log10(N)) + 1;
        pow = (int)Math.pow(10, d);

        q.add(encode(KnightPos[0],KnightPos[1]));
        isVisited.add(encode(KnightPos[0], KnightPos[1]));
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int temp = q.poll();
                int[] cell = decode(temp);
                if (cell[0] == TargetPos[0] && cell[1] == TargetPos[1]) return level;

                for (int[] m : moves) {
                    int c = encode(cell[0] + m[0], cell[1] + m[1]);
                    boolean possible = possible(cell[0] + m[0], cell[1] + m[1], N);
                    if (possible && !isVisited.contains(c)) {
                        isVisited.add(c);
                        q.add(c);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    private static boolean possible(int x, int y, int n) {
        if (x < 1 || x > n) return false;
        return y >= 1 && y <= n;
    }
    private static int encode(int x, int y) {
        return (x*pow) + y;
    }

    private static int[] decode (int cell) {
        return new int[] {cell/pow, cell%pow};
    }
}
