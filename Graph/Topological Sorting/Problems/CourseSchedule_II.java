
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule-ii/

public class CourseSchedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        // creating adjacency list along with filling inDegree array
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] e : prerequisites) {
            adj.get(e[0]).add(e[1]);
            inDegree[e[1]]++;
        }

        // Creating queue and filling it with the vertex whose inDegree is 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0) q.add(i);

        // Preparing for topoSort
        int idx = -1;
        int[] res = new int[numCourses];

        while (!q.isEmpty()) {
            int temp = q.poll();
            res[++idx] = temp;

            for (int i : adj.get(temp)) {
                inDegree[i]--;
                if (inDegree[i] == 0) q.add(i);
            }
        }

        // if index == numCourse - 1, that means all vertices are in resultant array
        // and if not, which means that graph contains cycle and hence return empty array
        if (idx != numCourses-1) return new int[]{};
        else {
            for (int i = 0; i < numCourses/2; i++) {
                int temp = res[i];
                res[i] = res[numCourses - i - 1];
                res[numCourses - i - 1] = temp;
            }

            return res;
        }
    }
}
