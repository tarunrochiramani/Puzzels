package com.tr.dataStrutsOperations;

import com.tr.datastruts.GraphNode;
import java.util.LinkedList;

public class GraphOperations {

    public void addAdjacentNode(GraphNode parent, GraphNode... adjacentNode) {
        for (GraphNode node : adjacentNode) {
            parent.getAdjacentNodes().add(node);
        }
    }

    // Returns the traversal path
    public String doBFS(GraphNode node) {
        if (node == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<GraphNode> bfsQueue = new LinkedList<GraphNode>();
        addNodeToQueue(bfsQueue, node);
        while (!bfsQueue.isEmpty()) {
            GraphNode nodeToTraverse = bfsQueue.remove();

            for (Object adjacentNode : nodeToTraverse.getAdjacentNodes()) {
                if (!(adjacentNode instanceof GraphNode)) {
                    return null;
                }

                if (((GraphNode)adjacentNode).getNodeColor().equals(GraphNode.color.WHITE)) {
                    addNodeToQueue(bfsQueue, (GraphNode)adjacentNode);
                }
            }
            nodeToTraverse.setNodeColor(GraphNode.color.BLACK);
            stringBuilder.append(nodeToTraverse.getValue() + ";");
        }

        return stringBuilder.toString();
    }

    // Returns the traversal path
    public String doDFS(GraphNode node) {
        if (node == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        dfsVisit(node, stringBuilder);

        return stringBuilder.toString();
    }

    private void dfsVisit(GraphNode node, StringBuilder stringBuilder) {
        node.setNodeColor(GraphNode.color.GREY);
        stringBuilder.append(node.getValue() + ";");

        // find all adjacent node
        for (Object adjacentNode : node.getAdjacentNodes()) {
            if (((GraphNode)adjacentNode).getNodeColor().equals(GraphNode.color.WHITE)) {
                dfsVisit((GraphNode)adjacentNode, stringBuilder);
            }
        }

        node.setNodeColor(GraphNode.color.BLACK);
    }

    private void addNodeToQueue(LinkedList<GraphNode> bfsQueue, GraphNode node) {
        bfsQueue.add(node);
        node.setNodeColor(GraphNode.color.GREY);
    }

}
