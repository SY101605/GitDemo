package GitDemo;

import java.util.*;

public class PrimMSTOptimized {
    public static class Edge {
        int to;
        int weight;

        Edge (int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public static class Vertex implements Comparable<Vertex>{
        int id;
        int key;    //the smallest edge weight have been known so far

        Vertex(int id, int key){
            this.id = id;
            this.key = key;
        }

        @Override
        public int compareTo(Vertex other){
            return Integer.compare(this.key, other.key);
        }

    }
    public static int primMSTOptimized(List<List<Edge>> graph, int n){
        if (n <= 0) return 0;

        //使用数组储存每个顶点的最小权重
        int[] key = new int[n];
        //inMST用于标记每个顶点是否已经加入了最小生成树MST
        boolean[] inMST = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(0,0));

        //采取“惰性删除”策略：当顶点被取出时检查key值是否过期
        boolean[] inQueue = new boolean[n];
        inQueue[0] = true;

        int totalWeight = 0;
        while (!pq.isEmpty()){
            Vertex current = pq.poll();
            int u = current.id;

            //如果这个顶点的key值已经过期（说明有更小的key值被更新了），跳过
            //保证只处理最新的，最小的key值，每个顶点只被处理一次
            if (current.key > key[u] || inMST[u]){
                continue;
            }
            inMST[u] = true;
            totalWeight += key[u];

            for (Edge edge : graph.get(u)){
                int v = edge.to;
                int weight = edge.weight;

                if (!inMST[v] && weight < key[v]){
                    key[v] = weight;
                    pq.offer(new Vertex(v, weight));
                }
            }
        }
        return totalWeight;
    }
}
