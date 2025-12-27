package GitDemo;

import java.util.*;

public class KruskalMST {

    static class Edge implements Comparable<Edge>{
        int src;    //initial vertex
        int dest;   //target vertex
        int weight;

        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other){
            return Integer.compare(this.weight, other.weight);
        }

        @Override
        public String toString(){
            return src + " - " + dest + " : " + weight;
        }
    }
    /**
     * 并查集(Union-Find)实现
     * 用于检测环
     */
     static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;  //连通分量数量

        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            count = n;

            for (int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
    }
        public int find(int x){
                if (parent[x] != x){
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }
        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY){
                return false;
            }

            if (rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            }else{
                parent[rootX] = rootY;
                rank[rootY]++;
            }
            count--;
            return true;
        }

        public boolean connected(int  x, int y){
            return find(x) == find(y);
        }

        public int getCount(){
            return count;
        }

    }

    /**
     * Kruskal 算法求最小生成树
     * @param edges 边的列表
     * @param n 顶点数量
     * @return 最小生成树的权重，如果图不连通则返回-1
     */
    public static int KruskalMST(List<Edge> edges, int n){
        if (n <= 0) return 0;

        //1.按权重排序所有边
        Collections.sort(edges);
        //2.初始化并查集
        UnionFind uf = new UnionFind(n);
        //3.遍历边，构建MST
        int totalWeight = 0;
        int edgesUsed = 0;

        for (Edge edge : edges){
            if (edgesUsed == n-1){
                break;
            }
            if (uf.union(edge.src, edge.dest)){
                totalWeight += edge.weight;
                edgesUsed++;
            }
        }
        if (uf.getCount() != 1){
            return -1;
        }
        return totalWeight;
    }
}
