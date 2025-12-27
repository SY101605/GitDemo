package GitDemo;
import java.util.*;

public class DijkstraAlgorithm {
    //求一个点到另外一个点的最短路径，每次都选距离a最近的点，然后更新
    static class Edge {
        int weight; //权重
        int target; //目标节点

        Edge (int target, int weight){
            this.target = target;
            this.weight = weight;
        }
    }
    static class Node implements Comparable<Node> {
        int id;
        int distance;

        Node(int id, int distance){
            this.id = id;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(this.distance, other.distance);
        }
    }

    /**
     * DijkstraAlgorithm
     * @Param graph 邻接表表示的图
     * @Param start 起始节点
     * @return 包含最短距离和路径信息的数组
     */
    public static int[] dijkstra(List<List<Edge>> graph, int start){
        int n = graph.size();
        int[] dist = new int[n];
        int[] prev = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node current = pq.poll();
            int u = current.id;

            if (visited[u]){
                continue;
            }

            visited[u] = true;

            for (Edge edge : graph.get(u)){
                int v = edge.target;
                int weight = edge.weight;

                if (!visited[v]){
                    int newDist = dist[u] + weight;

                    if (newDist < dist[v]){
                        dist[v] = newDist;
                        prev[v] = u;
                        pq.offer(new Node(v, newDist));
                    }
                }
            }
        }
        return dist;
    }
}
