package Strings;

import java.util.HashMap;
import java.util.Objects;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        int pLen = pattern.length();
        HashMap<Character, String> C_to_S = new HashMap<>();
        HashMap<String, Character> S_to_C = new HashMap<>();
        
        String[] words = s.split(" ");
        if (pLen != words.length) return false;
        
        for (int i = 0; i < pLen; i++) {
            char ch = pattern.charAt(i);
            if (C_to_S.containsKey(ch) && S_to_C.containsKey(words[i])) {
                if (!Objects.equals(C_to_S.get(ch), words[i])) return false;
                if (S_to_C.get(words[i]) != ch) return false;
            }else if (!C_to_S.containsKey(ch) && !S_to_C.containsKey(words[i])) {
                C_to_S.put(ch, words[i]);
                S_to_C.put(words[i], ch);
            }else return false;
        }
        
        return true;
    }
}
