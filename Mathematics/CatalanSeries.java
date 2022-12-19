import java.util.Arrays;

public class CatalanSeries {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Arrays.toString(createSeries(n)));
    }
    public static long[] createSeries(int n) {
        long[] res = new long[n+1];
        res[0] = res[1] = 1;

        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                res[i] += res[j] * res[i-j-1];
            }
        }
        return res;
    }
}
