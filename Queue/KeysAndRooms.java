import java.util.*;

// https://leetcode.com/problems/keys-and-rooms/description/

public class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(1));
        input.add(List.of(2));
        input.add(List.of(3));
        input.add(new ArrayList<>());
        System.out.println(approach1(input));
    }

    //approach 1
    public static boolean approach1(List<List<Integer>> rooms) {
        Queue<Integer> to_visit = new LinkedList<>();
        HashSet<Integer> keys = new HashSet<>();
        keys.add(0);
        final int n = rooms.size();

        for (int i = 0; i < n; i++)
            to_visit.add(i);


        while (!to_visit.isEmpty()){
            boolean visit = false;
            for (int i = 0; i < to_visit.size(); i++) {
                int room = to_visit.poll();
                if (keys.contains(to_visit.peek())){
                    keys.addAll(rooms.get(room));
                    visit = true;
                }
                else to_visit.add(room);
            }
            if (!visit) return false;
            if (keys.size() == n) return true;
        }

        return true;
    }


    // approach 2
    public boolean approach2(List<List<Integer>> rooms) {
        Queue<Integer> keys = new LinkedList<>();
        keys.add(0);

        HashSet<Integer> visited = new HashSet<>();
        while (!keys.isEmpty()) {
            int room = keys.poll();
            if (!visited.contains(room)) {
                keys.addAll(rooms.get(room));
                visited.add(room);
            }
        }

        return visited.size() == rooms.size();
    }

    // actually this question related topics were DFS, BFS and Graph but since I haven't learn those topics yet
    // so I solved it however I apprehend this.
}

