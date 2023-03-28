import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/alien-dictionary/1
public class AlienDictionary {
    public static void main(String[] args) {
        int n = 5, k = 4;
        String[] dict = {"baa","abcd","abca","cab","cad"};
        System.out.println(findOrder(dict, n, k));
    }

    public static String findOrder(String [] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[K];

        for (int i = 0; i < K; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < N-1; i++) {
            int j = 0;
            while (j < dict[i].length()) {
                if (dict[i].charAt(j) != dict[i+1].charAt(j)) {
                    adj.get(dict[i].charAt(j) - 'a').add(dict[i+1].charAt(j) - 'a');
                    inDegree[dict[i+1].charAt(j) - 'a']++;
                    break;
                }
                j++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int temp = q.poll();
            sb.append((char)(temp + 'a'));

            for (int i : adj.get(temp)) {
                inDegree[i]--;
                if (inDegree[i] == 0) q.add(i);
            }
        }

        return sb.toString();
    }
}
