package com.tr.dataStrutsOperations;

import com.tr.datastruts.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BinaryTreeOperations {
    private static Logger logger = Logger.getLogger(BinaryTreeOperations.class.getCanonicalName());

    public BinaryTreeNode insert(BinaryTreeNode head, int value) {
        BinaryTreeNode newNode = new BinaryTreeNode(value);

        if (head == null) {
            return newNode;
        }

        BinaryTreeNode current = head;
        BinaryTreeNode parent = null;
        while (current != null) {
            parent = current;
            if ( value > current.getValue()) {
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }

        if (value <= parent.getValue()) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }

        return head;
    }

    public BinaryTreeNode insertRecursive(BinaryTreeNode node, int value) {
        if (node == null) {
            node = new BinaryTreeNode(value);
        } else {
            if (value <= node.getValue()) {
                node.setLeft(insertRecursive(node.getLeft(), value));
            } else {
                node.setRight(insertRecursive(node.getRight(), value));
            }
        }

        return node;
    }

    public void printInorder(BinaryTreeNode node, List<Integer> fillValues) {
        if (node == null) {
            return;
        }

        printInorder(node.getLeft(), fillValues);
        logger.info(Integer.toString(node.getValue()));
        fillValues.add(node.getValue());
        printInorder(node.getRight(), fillValues);
    }

    public int getHeight(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getHeight(node.getLeft());
        if (left == -1) return -1;

        int right = getHeight(node.getRight());
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(BinaryTreeNode node) {
        if (getHeight(node) == -1) {
            return false;
        }

        return true;
    }

    public int getActualHeight(BinaryTreeNode head) {
        if (head == null) {
            return 0;
        }

        return Math.max(getActualHeight(head.getLeft()), getActualHeight(head.getRight())) + 1;
    }

    public BinaryTreeNode createMinimalBST(int[] values, int start, int end) {
        BinaryTreeNode head = null;
        if (values == null || values.length == 0) {
            return null;
        }

        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        head = new BinaryTreeNode(values[mid]);
        head.setLeft(createMinimalBST(values, start, mid - 1));
        head.setRight(createMinimalBST(values, mid + 1, end));

        return head;
    }

    public List<List<Integer>> getListForAllDepths(BinaryTreeNode head) {
        if (head == null) {
            return null;
        }

        List<List<Integer>> results = null;
        if (head.getLeft() == null && head.getRight() == null) {
            results = new ArrayList<List<Integer>>();
            List<Integer> valuesList = new ArrayList<Integer>();
            valuesList.add(head.getValue());
            results.add(valuesList);
            return results;
        }

        List<List<Integer>> leftResults = getListForAllDepths(head.getLeft());
        List<List<Integer>> rightResults = getListForAllDepths(head.getRight());

        results = merge(leftResults, rightResults);
        addCurrentNodeToResults(results, head.getValue());

        return results;
    }

    public boolean isBST(BinaryTreeNode head) {
        if (head == null) {
            return true;
        }

        if (head.getLeft() != null) {
            if (head.getLeft().getValue() > head.getValue()) {
                return false;
            }
        }

        if (head.getRight() != null) {
            if (head.getRight().getValue() <= head.getValue()) {
                return false;
            }
        }

        if (!isBST(head.getLeft()) || !isBST(head.getRight())) {
            return false;
        }

        return true;
    }

    public BinaryTreeNode getInorderSuccessor(BinaryTreeNode node) throws Exception {
        if (node == null) {
            return null;
        }

        if (node.getRight() != null) {
            return getMin(node.getRight());
        }

        BinaryTreeNode result = null;
        while (true) {
            BinaryTreeNode parentNode = node.getParent();
            if (parentNode == null) {
                break;
            }

            if (parentNode.getLeft() == node) {
                result = parentNode;
                break;
            }
            node = parentNode;
        }

        return result;
    }

    public BinaryTreeNode getMin(BinaryTreeNode node) throws Exception {
        if (node == null) {
            throw new Exception("Bad Input");
        }

        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }

    //Common Ancestor is solved for a Binary Tree NOT Binary Search Tree
    public BinaryTreeNode getCommonAncestor(BinaryTreeNode head, BinaryTreeNode node1, BinaryTreeNode node2) {
        if (head == null || node1 == null || node2 == null) {
            return null;
        }

        List<BinaryTreeNode> nodes = findAncestor(head, node1, node2);
        if (nodes.contains(node1) && nodes.contains(node2)) {
            return nodes.get(nodes.size() -1);
        }

        return null;
    }

    // assume tree has unique node values
    private List<BinaryTreeNode> findAncestor(BinaryTreeNode head, BinaryTreeNode node1, BinaryTreeNode node2) {
        if (head == null) {
            return new ArrayList<BinaryTreeNode>();
        }

        List<BinaryTreeNode> leftSearch = findAncestor(head.getLeft(), node1, node2);
        List<BinaryTreeNode> rightSearch = findAncestor(head.getRight(), node1, node2);

        leftSearch.addAll(rightSearch);
        if (leftSearch.contains(node1) && leftSearch.contains(node2)) {
            if (leftSearch.size() == 2) {
                leftSearch.add(head);
            }
            return leftSearch;
        }

        if (head.getValue() == node1.getValue() || head.getValue() == node2.getValue()) {
            leftSearch.add(head);
        }
        return leftSearch;
    }


    private void addCurrentNodeToResults(List<List<Integer>> results, int value) {

        if (results == null) {
            return;
        }

        for(List<Integer> result : results) {
            result.add(value);
        }
    }

    private List<List<Integer>> merge(List<List<Integer>> leftResults, List<List<Integer>> rightResults) {
        if (leftResults == null) {
            return rightResults;
        }

        if (rightResults == null) {
            return leftResults;
        }

        leftResults.addAll(rightResults);

        return leftResults;
    }
}
