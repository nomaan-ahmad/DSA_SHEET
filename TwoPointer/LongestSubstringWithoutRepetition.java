import java.util.Arrays;

public class LongestSubstringWithoutRepetition {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
        int max = Integer.MIN_VALUE;

        int i = 0, j = 0;
        while (j < len) {
            char ch = s.charAt(j);
            if (lastIndex[ch] == -1) {
                lastIndex[ch] = j;
                max = Math.max(max, j-i+1);
                j++;
            }else {
                int pos = lastIndex[ch];
                while (i <= pos) {
                    lastIndex[s.charAt(i)] = -1;
                    i++;
                }
            }
        }
        return max;
    }
}