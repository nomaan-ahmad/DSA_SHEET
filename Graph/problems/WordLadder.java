package Graph.problems;

import java.util.*;

// https://leetcode.com/problems/word-ladder/description/
public class WordLadder {
    public static void main(String[] args) {
        String[] str = {"hot","dot","dog","lot","log","cog"};
        String begin = "hit";
        String end = "cog";

        System.out.println(ladderLength(begin, end, Arrays.asList(str)));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 1;
        HashSet<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;

        HashSet<String> isVisited = new HashSet<>();
        isVisited.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String s = q.poll();
                StringBuilder sb = new StringBuilder(s);
                for (int pos = 0; pos < sb.length(); pos++) {
                    char originalChar = sb.charAt(pos);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(pos,c);
                        String temp = sb.toString();
                        if (endWord.equals(temp)) return dist + 1;
                        if (words.contains(temp) && !isVisited.contains(temp)) {
                            q.add(temp);
                            isVisited.add(temp);
                        }
                    }
                    sb.setCharAt(pos, originalChar);
                }
            }
            dist++;
        }

        return 0;
    }
}