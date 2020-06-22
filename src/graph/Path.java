package graph;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private final List<String> nodes = new ArrayList<>();

    public void add(String node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "Path{" +
                "nodes=" + nodes +
                '}';
    }
}
