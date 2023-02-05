package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length(), sLen = s.length();
        List<Integer> res = new ArrayList<>();

        if (pLen > sLen) return res;

        HashMap<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < pLen; i++)
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);

        int[] sMap = new int[26];

        int i = 0;
        while (i < pLen) {
            sMap[s.charAt(i) - 'a']++;
            i++;
        }

        if (match(sMap, pMap)) res.add(0);

        while (i < sLen) {
            sMap[s.charAt(i) - 'a']++;
            sMap[s.charAt(i-pLen) - 'a']--;

            if (match(sMap, pMap)) res.add(i-pLen+1);
            i++;
        }
        return res;
    }

    private static boolean match(int[] s, HashMap<Character, Integer> p) {
        for (Character c : p.keySet())
            if (p.get(c) != s[c - 'a']) return false;

        return true;
    }
}
