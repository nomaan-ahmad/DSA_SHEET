package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
    The problem is we have to traverse a matrix and generate a path to reach the destination from the source
    where value signifies as follows:
    0 : we can go into that cell
    1: we can't enter those cells
 */

 // In this problem, we have to print all possible path from source to destination while dodging all obstacles
 
public class MazeProblem {
    private static class Position {
        int x;
        int y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }


        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0,1,0},
                {0,0,1},
                {0,0,0}
        };

        List<List<Position>> possiblePath = new ArrayList<>();
        generate(possiblePath, new ArrayList<>(), mat, 0, 0);

        for (List<Position> li : possiblePath)
            System.out.println(li);
    }

    private static void generate(List<List<Position>> res, List<Position> path, int[][] mat, int i, int j){
        path.add(new Position(i,j));
        int size = path.size();
        if (i >= mat.length || j >= mat[0].length || mat[i][j] == 1) {
            path.remove(size-1);
            return;
        }
        if (i == mat.length-1 && j == mat[0].length-1) {
            res.add(new ArrayList<>(path));
            path.remove(size-1);
            return;
        }

        generate(res, path, mat, i+1, j);
        generate(res, path, mat, i, j+1);

        path.remove(size-1);
    }

}
