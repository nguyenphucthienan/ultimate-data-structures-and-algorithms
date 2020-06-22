package datastructure.graph;

import java.util.*;

public class Graph {

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private final Map<String, Node> nodes = new HashMap<>();
    private final Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null) {
            throw new IllegalArgumentException();
        }

        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null) {
            return;
        }

        for (Node n : adjacencyList.keySet()) {
            adjacencyList.get(n).remove(node);
        }

        adjacencyList.remove(node);
        nodes.remove(node.label);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null) {
            return;
        }

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void print() {
        for (Node source : adjacencyList.keySet()) {
            List<Node> targets = adjacencyList.get(source);
            if (targets.size() > 0) {
                System.out.println(source + " is connected to " + targets);
            }
        }
    }

    public void traverseDepthFirstRecursive(String root) {
        Node node = nodes.get(root);
        if (node == null) {
            throw new IllegalArgumentException();
        }

        traverseDepthFirstRecursive(node, new HashSet<>());
    }

    private void traverseDepthFirstRecursive(Node root, Set<Node> visited) {
        if (visited.contains(root)) {
            return;
        }

        System.out.println(root.label);
        visited.add(root);

        for (Node neighbor : adjacencyList.get(root)) {
            traverseDepthFirstRecursive(neighbor, visited);
        }
    }

    public void traverseDepthFirst(String root) {
        Node node = nodes.get(root);
        if (node == null) {
            throw new IllegalArgumentException();
        }

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (visited.contains(current)) {
                continue;
            }

            System.out.println(current.label);
            visited.add(current);

            for (Node neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
    }

    public void traverseBreathFirst(String root) {
        Node node = nodes.get(root);
        if (node == null) {
            throw new IllegalArgumentException();
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (visited.contains(current)) {
                continue;
            }

            System.out.println(current.label);
            visited.add(current);

            for (Node neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
    }

    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for (Node node : nodes.values()) {
            topologicalSort(node, visited, stack);
        }

        List<String> sorted = new ArrayList<>();
        while (!stack.empty()) {
            sorted.add(stack.pop().label);
        }

        return sorted;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        for (Node neighbor : adjacencyList.get(node)) {
            topologicalSort(neighbor, visited, stack);
        }

        stack.push(node);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>(nodes.values());
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            Node current = all.iterator().next(); // First item
            if (hasCycle(current, all, visiting, visited)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for (Node neighbor : adjacencyList.get(node)) {
            if (visited.contains(neighbor)) {
                continue;
            }

            if (visiting.contains(neighbor)) {
                return true;
            }

            if (hasCycle(neighbor, all, visiting, visited)) {
                return true;
            }
        }

        visiting.remove(node);
        visited.add(node);
        return false;
    }
}
