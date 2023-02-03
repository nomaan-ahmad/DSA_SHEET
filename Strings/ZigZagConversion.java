// https://leetcode.com/problems/zigzag-conversion/

public class ZigZagConversion {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        System.out.println(convert(str, 4));
    }
    public static String convert(String s, int numRows) {
        final int n = s.length();
        if (numRows == 1 || n <= numRows) return s;

        StringBuilder str = new StringBuilder();
        int k = (numRows-1) * 2;

        // first row
        int i = 0;
        while (i < n) {
            str.append(s.charAt(i));
            i += k;
        }

        // Intermediate rows

        for (int j = 1; j < numRows-1; j++) {
            int c = (numRows - 1) * 2 - (2*j);

            int index = j;
            while (index < n) {
                str.append(s.charAt(index));

                index += c;
                if (index < n) str.append(s.charAt(index));

                index += Math.abs(k - c);
            }
        }

        // last row
        i = numRows-1;
        while (i < n) {
            str.append(s.charAt(i));
            i += k;
        }

        return str.toString();
    }
}