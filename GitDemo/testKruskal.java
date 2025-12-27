package GitDemo;

import java.util.*;

class TestKruskal {
    /**
     * 创建测试图
     */
    private static List<KruskalMST.Edge> createTestGraph() {
        List<KruskalMST.Edge> edges = new ArrayList<>();

        // 示例图
        edges.add(new KruskalMST.Edge(0, 1, 2));
        edges.add(new KruskalMST.Edge(0, 3, 6));
        edges.add(new KruskalMST.Edge(1, 2, 3));
        edges.add(new KruskalMST.Edge(1, 3, 8));
        edges.add(new KruskalMST.Edge(1, 4, 5));
        edges.add(new KruskalMST.Edge(2, 4, 7));
        edges.add(new KruskalMST.Edge(3, 4, 9));

        return edges;
    }

    /**
     * 测试主方法
     */
    public static void main(String[] args) {
        System.out.println("=== Kruskal Algorithm Test ===");

        // 测试用例1：基本图
        List<KruskalMST.Edge> edges = createTestGraph();
        int n = 5;  // 5个顶点

        System.out.println("\nTest Case 1: Basic Graph");
        System.out.println("Number of vertices: " + n);
        System.out.println("Number of edges: " + edges.size());

        // 计算MST权重
        int totalWeight = KruskalMST.KruskalMST(edges, n);
        System.out.println("MST total weight: " + totalWeight);
        System.out.println("Expected weight: 16");
        System.out.println("Test: " + (totalWeight == 16 ? "✓ PASS" : "✗ FAIL"));

        // 测试用例2：不连通图
        System.out.println("\n\nTest Case 2: Disconnected Graph");
        List<KruskalMST.Edge> disconnectedEdges = new ArrayList<>();
        disconnectedEdges.add(new KruskalMST.Edge(0, 1, 2));
        disconnectedEdges.add(new KruskalMST.Edge(1, 2, 3));
        // 顶点3和4是孤立的

        int disconnectedWeight = KruskalMST.KruskalMST(disconnectedEdges, 5);
        System.out.println("MST weight for disconnected graph: " + disconnectedWeight);
        System.out.println("Expected: -1 (disconnected)");
        System.out.println("Test: " + (disconnectedWeight == -1 ? "✓ PASS" : "✗ FAIL"));

        // 测试用例3：单个顶点
        System.out.println("\n\nTest Case 3: Single Vertex");
        List<KruskalMST.Edge> singleVertexEdges = new ArrayList<>();
        int singleWeight = KruskalMST.KruskalMST(singleVertexEdges, 1);
        System.out.println("MST weight for single vertex: " + singleWeight);
        System.out.println("Expected: 0");
        System.out.println("Test: " + (singleWeight == 0 ? "✓ PASS" : "✗ FAIL"));

        // 测试用例4：复杂图
        System.out.println("\n\nTest Case 4: Complex Graph");
        List<KruskalMST.Edge> complexEdges = new ArrayList<>();
        complexEdges.add(new KruskalMST.Edge(0, 1, 7));
        complexEdges.add(new KruskalMST.Edge(0, 3, 5));
        complexEdges.add(new KruskalMST.Edge(1, 2, 8));
        complexEdges.add(new KruskalMST.Edge(1, 3, 9));
        complexEdges.add(new KruskalMST.Edge(1, 4, 7));
        complexEdges.add(new KruskalMST.Edge(2, 4, 5));
        complexEdges.add(new KruskalMST.Edge(3, 4, 15));
        complexEdges.add(new KruskalMST.Edge(3, 5, 6));
        complexEdges.add(new KruskalMST.Edge(4, 5, 8));
        complexEdges.add(new KruskalMST.Edge(4, 6, 9));
        complexEdges.add(new KruskalMST.Edge(5, 6, 11));

        int complexWeight = KruskalMST.KruskalMST(complexEdges, 7);
        System.out.println("MST weight for complex graph: " + complexWeight);
        System.out.println("Expected: 39");
        System.out.println("Test: " + (complexWeight == 39 ? "✓ PASS" : "✗ FAIL"));
    }
}