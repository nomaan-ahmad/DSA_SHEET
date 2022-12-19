// https://leetcode.com/problems/first-unique-character-in-a-string/description/

public class FirstUniqueCharacter {

    // 1. First Approach - using HashMap

    // Approach where we just used hashmap to check status of any character
    // if any character comes more than 1 time then we'll just put its status as -1
    // otherwise we'll just store its index

    // This is a 2 pass approach because we're traversing String 2 times

    public int firstApproach(String s) {
        HashMap<Character, Integer> status = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (status.containsKey(ch)) status.put(ch, -1);
            else status.put(ch, i); 
        }

        for (int i = 0; i < s.length(); i++) 
            if (status.get(s.charAt(i)) >= 0) return i;

        return -1;
    }


    // 2. Second Approach

    // Here we will use status Array to check the status of each character
    // and then we'll iterate over status array to find smallest index which came only 1 times

    // this will be 1 pass approach because status array is finite (i.e 26 size) so it's iteration is negligible

    public int secondApproach(String s) {
        int[] count = new int[26];
        Arrays.fill(count, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (count[ch - 'a'] == -1) count[ch - 'a'] = i;
            else count[ch - 'a'] = -2;
        }

        int res = Integer.MAX_VALUE;
        for (int i : count) {
            if (i >= 0) res = Math.min(res, i);
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}