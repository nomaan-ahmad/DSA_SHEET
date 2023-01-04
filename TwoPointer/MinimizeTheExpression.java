/*
 * We have been given three array, the task is to select (a,b,c) such that { a = A[i], b = B[j] and c = C[k] }
 * and we have to find minimum value possible of the expression:- {max(a,b,c) - min(a,b,c)}
 */
public class MinimizeTheExpression {
    public static void main(String[] args) {
        int[] D = { 1, 4, 5, 8, 10 };
        int[] E = { 6, 8, 9, 15 };
        int[] F = { 2, 3, 5, 6, 8 };
        System.out.println(minimize(D, E, F));
    }
    private static int minimize(int[] A, int[] B, int[] C) {
        int i = 0, j = 0, k = 0;
        int res = Integer.MAX_VALUE;
        while (i < A.length && j < B.length && k < C.length) {
            int min = Math.min(A[i], Math.min(B[j], C[k]));
            int max = Math.max(A[i], Math.max(B[j], C[k]));
            res = Math.min(res, max - min);

            if (res == 0) return res; // minimum possible value can be 0 when all (A[i],B[j],C[k]) -> (0,0,0)

            if ((A[i] < B[j]) && (A[i] < C[k])) i++;
            else if ((B[j] < A[i]) && (B[j] < C[k])) j++;
            else k++;
        }

        return res;
    }
}
