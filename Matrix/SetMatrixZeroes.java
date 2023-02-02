
// https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        setZeroes(matrix);

        for (int[] a : matrix) {
            for (int b : a)
                System.out.print(b + " ");

            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean isRow = false, isCol = false;

        // checking first row
        for (int[] a : matrix)
            if (a[0] == 0){
                isRow = true;
                break;
            }

        // checking first column
        for (int i = 0; i < matrix[0].length; i++)
            if (matrix[0][i] == 0) {
                isCol = true;
                break;
            }

        // if (mat[i][j] == 0) then mark mat[i][0] and mat[0][j] as '0'
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }

        // Now mark every cell as '0' where mat[i][0] == 0 || mat[0][j] == 0
        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }

        // if isRow == true
        if (isRow) {
            for (int[] a : matrix)
                a[0] = 0;
        }

        // if isCol == true
        if (isCol) {
            for (int i = 0; i < m; i++)
                matrix[0][i] = 0;
        }
    }
}
