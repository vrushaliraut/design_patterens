package models;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardSystem {
    HashMap<Integer, models.Node> nodes;
    Map<Integer, List<Node>> parents;

    public BoardSystem() {
        nodes = new HashMap<>();
        parents = new HashMap<>();
    }

    public void initialize(int[] nodes, int[][] edges, String[] types) {
        this.nodes.clear();
        this.parents.clear();

        assert nodes.length != 0;
        assert edges.length != 0;
        assert nodes.length == types.length;

        for (int i = 0; i < nodes.length; i++) {
            addNode(nodes[i], Enum.valueOf(BoardType.class, types[i]));
        }

        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }
    }

    private void addEdge(int parentId, int childId) {
        //validate not cycle
        parents.putIfAbsent(childId, new ArrayList<>());
        parents.get(childId).add((Node) nodes.get(parentId));
    }

    private void addNode(int id, BoardType boardType) {
        models.Node node = new models.Node(id, boardType);

        //validate node with id not exists
        nodes.put(id, node);
    }

    List<Integer> sortedNodes;
    Map<Integer, Integer> resultMap;

    public int compute() {
        sortedNodes = new ArrayList<>();
        resultMap = new HashMap<>();

        for (int nodeId : nodes.keySet()) {
            dfs(nodeId);
        }

        int last = sortedNodes.get(sortedNodes.size() - 1);
        return resultMap.get(last);
    }

    private void dfs(int nodeId) {
        if (resultMap.containsKey(nodeId)) {
            return;
        }
        Node node = (Node) nodes.get(nodeId);
        if (((models.Node) node).inputs == null && this.parents.containsKey(nodeId)) {
            ((models.Node) node).setInputs(this.parents.get(nodeId));
        }
        if (((models.Node) node).inputs == null) return;

        for (models.Node parent : ((models.Node) node).inputs) {
            dfs(parent.id);
        }
        int res = ((models.Node) node).processor.compute(((models.Node) node).inputs);
        resultMap.put(nodeId, res);
        sortedNodes.add(nodeId);
    }
}
