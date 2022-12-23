// https://leetcode.com/problems/sudoku-solver/

public class SudokuSolver {

    final static int N = 9;
    boolean[] flag;
    boolean[][] rows;
    boolean[][] cols;
    boolean[][] subMatrix;
    char[] integer = {'1','2','3','4','5','6','7','8','9'};

    public void solveSudoku(char[][] board) {
        
        rows = new boolean[N][N];
        cols = new boolean[N][N];
        subMatrix = new boolean[N][N];
        flag = new boolean[]{false};

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++){
                char ch = board[i][j];
                if (board[i][j] != '.') {
                    rows[i][(ch - '0') - 1] = true;
                    cols[j][(ch - '0') - 1] = true;

                    int matRow = (i/3) * 3;
                    int colRow = ((j/3) * 3) / 3;
                    subMatrix[matRow + colRow][(ch - '0') - 1] = true;
                }
            }

        backtrack(board, 0, 0);
    }


    private void backtrack(char[][] board, int i, int j) {
        if (flag[0]) return;
        
        if (i == N) flag[0] = true;
        else if (j == N) backtrack(board,i+1, 0);
        else if (board[i][j] != '.') backtrack(board, i, j+1);
        else {
            for (int it = 0; it < N; it++){
                char ch = integer[it];
                int subMat = ((i / 3) * 3) + (((j / 3) * 3) / 3); // submatrix coordinate
                if (!rows[i][(ch - '0')-1] && !cols[j][(ch - '0')-1] && !subMatrix[subMat][(ch - '0')-1]) {
                    rows[i][(ch - '0')-1] = true;
                    cols[j][(ch - '0')-1] = true;
                    subMatrix[subMat][(ch - '0')-1] = true;
                    board[i][j] = ch;

                    backtrack(board, i, j+1);

                    if (flag[0]) return; // if we found the solution don't revert the matrix

                    rows[i][(ch - '0')-1] = false;
                    cols[j][(ch - '0')-1] = false;
                    subMatrix[subMat][(ch - '0')-1] = false;
                    board[i][j] = '.';
                }
            }
        }
    }
}