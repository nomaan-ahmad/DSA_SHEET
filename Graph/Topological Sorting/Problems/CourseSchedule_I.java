
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/course-schedule/description/

public class CourseSchedule_I {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] isVisited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (isVisited[i] == 0)
                if(dfs(i, adj, isVisited)) return false;
        }

        return true;
    }

    // cycle detection mechanism using DFS
    private boolean dfs(int node, List<List<Integer>> adj, int[] isVisited) {
        if (isVisited[node] == 1) return true;
        if (isVisited[node] == 2) return false;

        isVisited[node] = 1;

        for (int i : adj.get(node)) {
            if (dfs(i, adj, isVisited)) return true;
        }

        isVisited[node] = 2;
        return false;
    }
}
