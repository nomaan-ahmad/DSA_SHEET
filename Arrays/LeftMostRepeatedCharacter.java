
// https://practice.geeksforgeeks.org/problems/repeated-character2058/1

public class LeftMostRepeatedCharacter {
    char firstRep(String S){
        boolean[] exist = new boolean[26];
        int minIndex = Integer.MAX_VALUE;

        for (int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            if (exist[ch - 'a']) minIndex = i;
            else exist[ch - 'a'] = true;
        }
        return (minIndex == Integer.MAX_VALUE) ? '#' : S.charAt(minIndex);
    }
}
