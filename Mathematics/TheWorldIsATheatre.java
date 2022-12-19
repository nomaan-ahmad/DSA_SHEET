// https://codeforces.com/problemset/problem/131/C

import java.util.Scanner;

public class TheWorldIsATheatre {
    static long[][] C;
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            // we'll first make combination table using Pascal's triangle
            // why 61? because max combination we'll use it for (boys + girls) C teamSize
            // combination table
            C = buildPascalTriangle();

            int boys = in.nextInt();
            int girls = in.nextInt();
            int teamSize = in.nextInt();

            System.out.println(waysToBuildTeam(boys, girls, teamSize));
        }
    }

    private static long[][] buildPascalTriangle() {
        int size = 61;
        long[][] mat = new long[size][size];
        mat[0][0] = mat[1][0] = mat[1][1] = 1;
        for (int i = 2; i < size; i++) {
            mat[i][0] = mat[i][i] = 1;

            for (int j = 1; j < i; j++)
                mat[i][j] = mat[i-1][j-1] + mat[i-1][j];
        }
        return mat;
    }
    private static long waysToBuildTeam(int boys, int girls, int teamSize) {

        // constraints to build team is it should have no less than 4 boys and no less than 1 girl
        long totalPossible = C[boys+girls][teamSize];

        for (int i = 0; i < 4; i++) {
            long possibleWay;
            if (teamSize-i > girls) continue;
            possibleWay = C[boys][i] * C[girls][teamSize-i];
            totalPossible -= possibleWay;
        }

        if (boys >= teamSize) totalPossible -= C[boys][teamSize];

        return totalPossible;
    }
}