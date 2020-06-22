package datastructure.graph;

public class Main {

    public static void main(String[] args) {
        operateGraph();
        operateDependencyGraph();
        operateCyclicGraph();
        operateWeightedGraph();
        operateCyclicWeightedGraph();
        operateGetMinimumSpanningTreeWeightedGraph();
    }

    private static void operateGraph() {
        Graph graph = new Graph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.addEdge("A", "C");

        graph.traverseBreathFirst("A");
    }

    private static void operateDependencyGraph() {
        Graph dependencyGraph = new Graph();

        dependencyGraph.addNode("Dependency A");
        dependencyGraph.addNode("Dependency B");
        dependencyGraph.addNode("Library X (A and B use this)");
        dependencyGraph.addNode("Project");

        dependencyGraph.addEdge("Library X (A and B use this)", "Dependency A");
        dependencyGraph.addEdge("Library X (A and B use this)", "Dependency B");
        dependencyGraph.addEdge("Dependency A", "Project");
        dependencyGraph.addEdge("Dependency B", "Project");

        System.out.println(dependencyGraph.topologicalSort());
    }

    private static void operateCyclicGraph() {
        Graph cyclicGraph = new Graph();

        cyclicGraph.addNode("A");
        cyclicGraph.addNode("B");
        cyclicGraph.addNode("C");
        cyclicGraph.addNode("D");

        cyclicGraph.addEdge("A", "B");
        cyclicGraph.addEdge("B", "C");
        cyclicGraph.addEdge("A", "A");

        System.out.println(cyclicGraph.hasCycle());
    }

    private static void operateWeightedGraph() {
        WeightedGraph weightedGraph = new WeightedGraph();

        weightedGraph.addNode("A");
        weightedGraph.addNode("B");
        weightedGraph.addNode("C");
        weightedGraph.addNode("D");

        weightedGraph.addEdge("A", "B", 1);
        weightedGraph.addEdge("B", "C", 2);
        weightedGraph.addEdge("A", "C", 4);

        System.out.println(weightedGraph.getShortestPath("A", "C"));
    }

    private static void operateCyclicWeightedGraph() {
        WeightedGraph cyclicWeightedGraph = new WeightedGraph();

        cyclicWeightedGraph.addNode("A");
        cyclicWeightedGraph.addNode("B");
        cyclicWeightedGraph.addNode("C");

        cyclicWeightedGraph.addEdge("A", "B", 1);
        cyclicWeightedGraph.addEdge("B", "C", 2);
        cyclicWeightedGraph.addEdge("C", "A", 3);

        System.out.println(cyclicWeightedGraph.hasCycle());
    }

    private static void operateGetMinimumSpanningTreeWeightedGraph() {
        WeightedGraph graph = new WeightedGraph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 5);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "C", 2);

        WeightedGraph tree = graph.getMinimumSpanningTree();
        tree.print();
    }
}
