package lintcode;

import java.util.*;

/**
 * 图是否是树
 *
 * @author zhoubo
 * @create 2017-11-20 9:34
 */
public class L178 {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>(32);
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < 2; j++) {
                Set<Integer> pairs = graph.get(edges[i][j]);
                if (null == pairs) {
                    pairs = new HashSet<>();
                    graph.put(edges[i][j], pairs);
                }
                pairs.add(edges[i][1 - j]);
            }
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            Integer key = queue.poll();
            Set<Integer> vertexs = graph.get(key);
            if (null == vertexs) {
                continue;
            }
            for (Integer vertex : vertexs) {
                if (visited.contains(vertex)) {
                    return false;
                }
                queue.offer(vertex);
                visited.add(vertex);
                graph.get(vertex).remove(key);
            }
        }
        return visited.size() == n;
    }
}
