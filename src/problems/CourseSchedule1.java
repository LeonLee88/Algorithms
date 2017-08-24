package problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by leon on 8/4/17.
 */
public class CourseSchedule1 {
    public final static Integer UNVISITED = -1;
    public final static Integer VISITING = 0;
    public final static Integer VISITED = 1;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);
        int[] state = initState(numCourses);

        for (Integer v : graph.keySet()) {
            if (hasCycle(v, graph, state)) {
                return false;
            }
        }
        return true;
    }

    // mark and visit 2
    boolean hasCycle(Integer v, Map<Integer, List<Integer>> graph, int[] state) {
        if (state[v] == VISITED) {
            return false;
        }
        if (state[v] == VISITING) {
            return true;
        }
        state[v] = VISITING;
        for (Integer nei : graph.get(v)) {
            if (hasCycle(nei, graph, state)) {
                return true;
            }
        }
        state[v] = VISITED;
        return false;
    }

    int[] initState(Integer numCourses) {
        int[] state = new int[numCourses];
        for (int v = 0; v < numCourses; v++) {
            state[v] = UNVISITED;
        }
        return state;
    }

    Map<Integer, List<Integer>> buildGraph(Integer numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int v = 0; v < numCourses; v++) {
            graph.put(v, new LinkedList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> neis = graph.get(prerequisites[i][1]);
            neis.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1], neis);
        }
        return graph;
    }
}
