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

//    public Map<Integer, List<Integer>> getListForAllDepths(BinaryTreeNode head, List<Integer> buffer) {
//        if (head == null || buffer == null) {
//            return null;
//        }
//
//
//        Map<Integer, List<Integer>> results = new HashMap<Integer, List<Integer>>();
//        if (head.getLeft() == null && head.getRight() == null) {
//            List<Integer> valuesList = new ArrayList<Integer>(buffer);
//            valuesList.add(head.getValue());
//            results.put(head.getValue(), valuesList);
//            return results;
//        } else {
//            buffer.add(head.getValue());
//        }
//
//        Map<Integer, List<Integer>> leftResults = getListForAllDepths(head.getLeft(), buffer);
//        Map<Integer, List<Integer>> rightResults = getListForAllDepths(head.getRight(), buffer);
//
//        if (leftResults != null) {
//            results.putAll(leftResults);
//        }
//
//        if (rightResults !=null) {
//            results.putAll(rightResults);
//        }
//
//        return results;
//    }

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
