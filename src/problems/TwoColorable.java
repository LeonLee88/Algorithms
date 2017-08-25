package problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by leon on 9/7/17.
 */
public class TwoColorable {

    boolean isTwoColorable(List<Node> graph) {
        for (Node node : graph) {
            if (!bfs(node)) {
                return false;
            }
        }
        return true;
    }

    private boolean bfs(Node n) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(n);
        n.color = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                int color = cur.color;
                List<Node> neis = cur.neighbors;
                for (Node nei : neis) {
                    if (nei.color == 0) {
                        nei.color = color == 1 ? 2 : 1;
                        queue.offer(nei);
                    } else if (nei.color == color) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static class Node {
        int color;
        List<Node> neighbors;
    }

    final static int[] colors = {1, 2, 3};
    boolean isThreeColorable(List<Node> graph) {
        for (Node node : graph) {
            if (!dfs(node, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Node n, int preColor) {
        if(n.color != 0) {
            if(n.color == preColor) {
                return false;
            }
            for(Node nei : n.neighbors) {
                if(nei.color == 0 && !dfs(nei, n.color)) {
                    return false;
                }
            }
            return true;
        } else {
            for(int color : colors) {
                if(color == preColor) {
                    continue;
                }
                n.color = color;
                int neighborsAreTreeColorable = 0;
                for(Node nei : n.neighbors) {
                    if(!dfs(nei, n.color)) {
                        break;
                    }
                    neighborsAreTreeColorable++;
                }
                if(neighborsAreTreeColorable == n.neighbors.size()) {
                    return true;
                }
                n.color = 0;
            }
            Deque<String> a = new LinkedList<>();
            List<String> b = new LinkedList<String>(a);
            return false;
        }
    }
}
