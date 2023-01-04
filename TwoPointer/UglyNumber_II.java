// https://leetcode.com/problems/ugly-number-ii/

public class UglyNumber_II {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int[] aux = new int[n];
        aux[0] = 1;
        int i = 0;
        int pt2 = 0, pt3 = 0, pt5 = 0;
        while (i < n-1) {
            int p2 = aux[pt2] * 2;
            int p3 = aux[pt3] * 3;
            int p5 = aux[pt5] * 5;

            i++;
            if ((p2 == p3) && (p3 == p5)) {
                aux[i] = p2;
                pt2++;
                pt3++;
                pt5++;
            }else if (p2 == p3) {
                if (p2 < p5) {
                    aux[i] = p2;
                    pt2++;
                    pt3++;
                }else {
                    aux[i] = p5;
                    pt5++;
                }
            }else if (p3 == p5) {
                if (p3 < p2) {
                    aux[i] = p3;
                    pt3++;
                    pt5++;
                }else {
                    aux[i] = p2;
                    pt2++;
                }
            }else if (p2 == p5) {
                if (p2 < p3) {
                    aux[i] = p2;
                    pt2++;
                    pt5++;
                }else {
                    aux[i] = p3;
                    pt3++;
                }
            }else {
                if ((p2 < p3) && (p2 < p5)){
                    aux[i] = p2;
                    pt2++;
                }else if ((p3 < p2) && (p3 < p5)) {
                    aux[i] = p3;
                    pt3++;
                }else {
                    aux[i] = p5;
                    pt5++;
                }
            }
        }
        return aux[n-1];
    }
}
