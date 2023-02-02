// https://leetcode.com/problems/verifying-an-alien-dictionary/description/

public class VerifyAnAlienDictionary {
    public static void main(String[] args) {
        String order = "worldabcefghijkmnpqstuvxyz";
        String[] words = {"word","world","row"};
        System.out.println(isAlienSorted(words, order));
    }

    final static int ALPHABET_SIZE = 26;
    final static int[] orderArr = new int[ALPHABET_SIZE];
    
    public static boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            orderArr[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!isLexicographic(words[i], words[i+1])) return false;
        }

        return true;
    }

    private static boolean isLexicographic(String word1, String word2) {
        final int n = word1.length();
        final int m = word2.length();

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i++;
                j++;
            }else return orderArr[word1.charAt(i) - 'a'] < orderArr[word2.charAt(j) - 'a'];
        }

        return (i==n);
    }
}