package GitDemo;
import java.util.*;

public class test {

    private static void addEdge(List<List<PrimMSTOptimized.Edge>> graph, int u, int v, int w) {
        graph.get(u).add(new PrimMSTOptimized.Edge(v, w));
        graph.get(v).add(new PrimMSTOptimized.Edge(u, w));
    }

    private static List<List<PrimMSTOptimized.Edge>> createGraph(int n) {
        List<List<PrimMSTOptimized.Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        return graph;
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Prim MST Algorithm ===");

        int n = 5;
        List<List<PrimMSTOptimized.Edge>> graph = createGraph(n);

        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 3, 6);
        addEdge(graph, 1, 2, 3);
        addEdge(graph, 1, 3, 8);
        addEdge(graph, 1, 4, 5);
        addEdge(graph, 2, 4, 7);
        addEdge(graph, 3, 4, 9);

        int result = PrimMSTOptimized.primMSTOptimized(graph, n);
        System.out.println("MST weight: " + result);
        System.out.println("Expected: 16");
        System.out.println("Test: " + (result == 16 ? "PASS" : "FAIL"));

        // 测试用例2：简单图
        n = 4;
        graph = createGraph(n);

        addEdge(graph, 0, 1, 1);
        addEdge(graph, 0, 2, 4);
        addEdge(graph, 1, 2, 2);
        addEdge(graph, 1, 3, 5);
        addEdge(graph, 2, 3, 3);

        result = PrimMSTOptimized.primMSTOptimized(graph, n);
        System.out.println("\nTest Case 2 - Simple Graph:");
        System.out.println("  Vertices: " + n);
        System.out.println("  Expected MST weight: 6");
        System.out.println("  Actual MST weight: " + result);
        System.out.println("  Result: " + (result == 6 ? "PASS ✓" : "FAIL ✗"));

        // 测试用例3：单个顶点
        n = 1;
        graph = createGraph(n);

        result = PrimMSTOptimized.primMSTOptimized(graph, n);
        System.out.println("\nTest Case 3 - Single Vertex:");
        System.out.println("  Vertices: " + n);
        System.out.println("  Expected MST weight: 0");
        System.out.println("  Actual MST weight: " + result);
        System.out.println("  Result: " + (result == 0 ? "PASS ✓" : "FAIL ✗"));
    }


}
