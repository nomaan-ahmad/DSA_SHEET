import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;

        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        // if n == 0, it means any order of size tasks.length will work
        if (n == 0) return tasks.length;

        // we don't need to generate character sequence, we will only work with count of each character
        int[] count = new int[26];
        for (char c : tasks)
            count[c - 'A']++;

        // Creating a max-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> b - a
        );

        // adding all elements to max-heap from count array
        for (int i : count)
            if (i != 0) pq.add(i);


        // initializing the result variable
        int intervals = 0;


        // below loop will run until there is no process left for scheduling
        while (!pq.isEmpty()) {

            // creating an auxiliary array to store elements which couldn't participate in each cycle
            // because they are already been included once
            // and no element can be included in a cycle more than one time otherwise it'll violate scheduling rule
            List<Integer> aux = new ArrayList<>();

            // cycle will run n+1 time. Why? because after a single element is included once, it has to wait for
            // n units of cool down period, and including that element and n cool down period. It will make n+1 round in
            // 1 cycle
            for (int i = n; i >= 0; i--) {

                // Sometimes it can happen that queue becomes empty in middle of cycle, this means two possibilities
                // 1. There is no more element to process in this cycle as every element has used their turn
                // 2. Or there is no more element left to process in whole tasks array, we can confirm it from aux list
                //      if list is empty then just break, every process is scheduled already, if not then we'll add
                //      idle i+1 number of times
                if (pq.isEmpty()) {
                    if (!aux.isEmpty()) intervals += (i+1);
                    break;
                }

                // removing top most element from this list
                int temp = pq.poll();

                // if it has at least single process to schedule then add it in aux array to process later in next cycle
                if (temp-1 > 0) aux.add(temp-1);

                // incrementing interval
                intervals++;
            }

            // adding all process in aux list again into queue for next cycle
            pq.addAll(aux);
        }

        return intervals;
    }
}
