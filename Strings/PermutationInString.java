// https://leetcode.com/problems/permutation-in-string/

import java.util.HashMap;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";

        System.out.println(checkInclusion(s1, s2));
    }
    
    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            char c = s1.charAt(i);
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        int[] s2Map = new int[26];
        for (int i = 0; i < len1; i++) {
            s2Map[s2.charAt(i) - 'a']++;
        }

        if (match(s1Map, s2Map)) return true;

        for (int i = len1; i < len2; i++) {
            s2Map[s2.charAt(i) - 'a']++;
            s2Map[s2.charAt(i - len1) - 'a']--;

            if (match(s1Map, s2Map)) return true;
        }

        return false;
    }

    private static boolean match(HashMap<Character, Integer> s1, int[] s2) {
        for (Character c : s1.keySet())
            if (s1.get(c) != s2[c - 'a']) return false;

        return true;
    }
}