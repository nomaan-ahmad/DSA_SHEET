package Graph.problems;

// https://practice.geeksforgeeks.org/problems/knight-walk4521/1

import java.util.LinkedList;
import java.util.Queue;

public class KnightTour {
    /*
        Given a square chessboard, the initial position of Knight and position of a target.
        Find out the minimum steps a Knight will take to reach the target position.
        If it cannot reach the target position return -1.
     */

    private static class Pair {
        int x;
        int y;

        Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
    public int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N) {
        N++; // to make it actual size of matrix

        // if destination point is same as initial Knight's position then we'll just return 0
        if (KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1]) return 0;

        // if N <= 2 then it that situation it is impossible for knight to move anywhere, hence -1
        if (N <= 2 || KnightPos[0] >= N || KnightPos[1] >= N) return -1;

        // isVisited matrix to prevent from cycle
        boolean[][] isVisited = new boolean[N][N];

        // Queue for BFS
        Queue<Pair> q = new LinkedList<>();

        // adding initial knight's position to start BFS
        q.add(new Pair(KnightPos[0], KnightPos[1]));

        // marking isVisited true for initial knight's position
        isVisited[KnightPos[0]][KnightPos[1]] = true;

        // making directions matrix for all possible knight's movement
        final int[][] directions = {
                {2, 1}, {2, -1},
                {-2, -1}, {-2, 1},
                {-1, 2}, {-1, -2},
                {1, 2}, {1, -2}
        };

        // counter to see the current level
        int level = 0;

        // starting BFS
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Pair temp = q.poll();

                // if while pushing we find that this is the target destination then we'll just return current level
                if (temp.x == TargetPos[0] && temp.y == TargetPos[1]) return level;

                for (int[] dr : directions) {
                    int x = temp.x + dr[0];
                    int y = temp.y + dr[1];

                    if (isValid(x, y, N) && !isVisited[x][y]) {
                        isVisited[x][y] = true;
                        q.add(new Pair(x, y));
                    }
                }
            }
            // increasing level
            level++;
        }
        return -1;
    }

    private boolean isValid(int x, int y, int n) {
        return (x > 0 && x < n) && (y > 0 && y < n);
    }
}

