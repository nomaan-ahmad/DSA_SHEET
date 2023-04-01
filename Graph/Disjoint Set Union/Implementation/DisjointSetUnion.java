import java.util.HashMap;
import java.util.Map;

public class DisjointSetUnion {
    private final HashMap<Integer, Pair> map;
    private static class Pair{
        int parent;
        int size;
        private Pair(int _parent, int _size) {
            parent = _parent;
            size = _size;
        }
    }

    public DisjointSetUnion() {
        map = new HashMap<>();
    }

    public void makeSet(int node) {
        if (!map.containsKey(node))
            map.put(node, new Pair(node, 1));
    }

    public int find(int x) {
        if (x == map.get(x).parent) return x;

        return find(map.get(x).parent);
    }

    public void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if (p1 == p2) return;

        if (map.get(p1).size > map.get(p2).size) {
            map.get(p2).parent = p1;
            map.get(p1).size += map.get(p2).size;
        } else {
            map.get(p1).parent = p2;
            map.get(p2).size += map.get(p1).size;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Pair> m : map.entrySet()) {
            sb.append(m.getKey()).append(" --> Parent: ").append(m.getValue().parent).append(", Size ").append(m.getValue().size).append('\n');
        }

        return sb.toString();
    }
}
