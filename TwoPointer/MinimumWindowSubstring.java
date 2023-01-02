public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen < tLen) return "";

        int[] tFreq = new int[256];
        int j = 0, distinct = 0;

        while (j < tLen) {
            int index = t.charAt(j);
            if (tFreq[index] == 0) distinct++;
            tFreq[index]++;
            j++;
        }

        // Making first window
        j = 0;
        int count = 0;
        int left = -1;
        int right = -1;
        int[] sFreq = new int[256];

        while (j < sLen) {
            int index = s.charAt(j);
            sFreq[index]++;
            if (sFreq[index] == tFreq[index]) count++;
            if (count == distinct) {
                left = 0;
                right = j;
                break;
            }
            j++;
        }

        // if we get our result in first window only
        if (count != distinct) return "";
        if ((right - left + 1) == tLen) return s.substring(left, right+1);

        // if we still didn't get the answer then we'll start our search in remaining part
        int i = 0;

        while (j < sLen) {
            if (sFreq[s.charAt(i)] > tFreq[s.charAt(i)]) {
                while (sFreq[s.charAt(i)] > tFreq[s.charAt(i)]) {
                    sFreq[s.charAt(i)]--;
                    i++;
                }
                if ((j-i+1) < (right-left+1)) {
                    left = i;
                    right = j;
                }
            }else {
                j++;
                if (j < sLen) sFreq[s.charAt(j)]++;
            }
        }
        if (left == -1) return "";
        else return s.substring(left, right+1);
    }
}
