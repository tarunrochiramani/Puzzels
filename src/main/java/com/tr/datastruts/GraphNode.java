package com.tr.datastruts;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
    public enum color {WHITE, GREY, BLACK};

    private List<GraphNode<T>> adjacentNodes;
    private T value;
    private color nodeColor;

    public GraphNode(T value) {
        adjacentNodes = new ArrayList<GraphNode<T>>();
        nodeColor = color.WHITE;
        this.value = value;
    }

    public List<GraphNode<T>> getAdjacentNodes() {
        return adjacentNodes;
    }

    public T getValue() {
        return value;
    }

    public color getNodeColor() {
        return nodeColor;
    }

    public void setNodeColor(color nodeColor) {
        this.nodeColor = nodeColor;
    }
}
