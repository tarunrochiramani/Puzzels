package com.tr.dataStrutsOperations;

import com.tr.datastruts.BinaryTreeNode;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BinaryTreeOperationsTest {

    private BinaryTreeOperations binaryTreeOperations = new BinaryTreeOperations();
    private Logger logger = Logger.getLogger(BinaryTreeOperationsTest.class.getCanonicalName());


    @Test
    public void testGetHeightWhenTreeIsBalanced() {
        BinaryTreeNode head = new BinaryTreeNode(1);

        BinaryTreeNode leftNode = new BinaryTreeNode(2);

        BinaryTreeNode rightNode = new BinaryTreeNode(3);

        head.setLeft(leftNode);
        head.setRight(rightNode);

        assertTrue(binaryTreeOperations.isBalanced(head));
    }

    @Test
    public void testGetHeightWhenOnlyOneNode() {
        BinaryTreeNode head = new BinaryTreeNode(1);

        assertTrue(binaryTreeOperations.isBalanced(head));
    }

    @Test
    public void testGetHeightWhenOneSideWithMoreNumberOfNode() {
        BinaryTreeNode head = new BinaryTreeNode(1);

        BinaryTreeNode leftNode = new BinaryTreeNode(2);
        head.setLeft(leftNode);

        BinaryTreeNode left2Node = new BinaryTreeNode(3);
        leftNode.setLeft(left2Node);

        assertFalse(binaryTreeOperations.isBalanced(head));
    }


    @Test
    public void testInsertAndPrintInorder() {
        int[] values = {8, 5, 9, 7, 10, 2, 14};

        BinaryTreeNode head = null;
        for (int value : values) {
            head = binaryTreeOperations.insert(head, value);
        }

        Arrays.sort(values);
        List<Integer> inorderValues = new ArrayList<Integer>();
        binaryTreeOperations.printInorder(head, inorderValues);

        assertFalse(inorderValues.isEmpty());
        assertEquals(values.length, inorderValues.size());
        for (int count =0; count<values.length; count++) {
            assertEquals(values[count], inorderValues.get(count).intValue());
        }

    }

    @Test
    public void testInsertRecursiveAndPrintInorder() {
        int[] values = {8, 5, 9, 7, 10, 2, 14};

        BinaryTreeNode head = null;
        for (int value : values) {
            head = binaryTreeOperations.insertRecursive(head, value);
        }

        Arrays.sort(values);
        List<Integer> inorderValues = new ArrayList<Integer>();
        binaryTreeOperations.printInorder(head, inorderValues);

        assertFalse(inorderValues.isEmpty());
        assertEquals(values.length, inorderValues.size());
        for (int count =0; count<values.length; count++) {
            assertEquals(values[count], inorderValues.get(count).intValue());
        }
    }

    @Test
    public void testCreateMinimalBSTWithEmptyInput() {
        assertNull(binaryTreeOperations.createMinimalBST(null, 0, 0));
        assertNull(binaryTreeOperations.createMinimalBST(new int[]{}, 0 , 0));
    }

    @Test
    public void testCreateMinimalBSTWithOneInput() {
        assertEquals(1, binaryTreeOperations.createMinimalBST(new int[]{1}, 0 , 0).getValue());
    }


    @Test
    public void testCreateMinimalBSTWithValidInput() {
        int[] values = {1, 2, 3, 4, 5, 6, 7};
        BinaryTreeNode head = binaryTreeOperations.createMinimalBST(values, 0, values.length-1);

        assertNotNull(head);
        int height = binaryTreeOperations.getHeight(head);
        assertTrue(height > 0);
        assertTrue(height <= (values.length / 2));

        List<Integer> inorderValues = new ArrayList<Integer>();
        binaryTreeOperations.printInorder(head, inorderValues);

        assertFalse(inorderValues.isEmpty());
        assertEquals(values.length, inorderValues.size());
        for (int count =0; count<values.length; count++) {
            assertEquals(values[count], inorderValues.get(count).intValue());
        }
    }

    @Test
    public void testCreateMinimalBSTWithValidInputOddSized() {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8};
        BinaryTreeNode head = binaryTreeOperations.createMinimalBST(values, 0, values.length-1);

        assertNotNull(head);
        int height = binaryTreeOperations.getHeight(head);
        assertTrue(height > 0);
        assertTrue(height <= (values.length / 2));

        List<Integer> inorderValues = new ArrayList<Integer>();
        binaryTreeOperations.printInorder(head, inorderValues);

        assertFalse(inorderValues.isEmpty());
        assertEquals(values.length, inorderValues.size());
        for (int count =0; count<values.length; count++) {
            assertEquals(values[count], inorderValues.get(count).intValue());
        }
    }

    @Test
    public void testGetListForAllDepthsForInvalidInputs() {
        assertNull(binaryTreeOperations.getListForAllDepths(null));
        assertNull(binaryTreeOperations.getListForAllDepths(null));
    }

    @Test
    public void testGetListForAllDepthsForOneNode() {
        int[] values = {1};
        BinaryTreeNode head = null;
        for (int value : values) {
            head = binaryTreeOperations.insert(head, value);
        }


        List<List<Integer>> results = binaryTreeOperations.getListForAllDepths(head);

        assertNotNull(results);
        assertFalse(results.isEmpty());
        assertEquals(1, results.size());
        assertEquals(1, results.get(0).size());

        logger.info(results.toString());
    }

    @Test
    public void testGetListForAllDepthsForValidTree() {
        int[] values = {8, 5, 9, 7, 10, 2, 14};
        BinaryTreeNode head = null;
        for (int value : values) {
            head = binaryTreeOperations.insert(head, value);
        }

        List<List<Integer>> results = binaryTreeOperations.getListForAllDepths(head);

        assertNotNull(results);
        assertFalse(results.isEmpty());
        assertEquals(3, results.size());
        logger.info(results.toString());
    }

    @Test
    public void testIsBST() {
        BinaryTreeNode head = new BinaryTreeNode(5);
        head.setRight(new BinaryTreeNode(4));

        assertFalse(binaryTreeOperations.isBST(head));

        head = new BinaryTreeNode(5);
        head.setLeft(new BinaryTreeNode(6));

        assertFalse(binaryTreeOperations.isBST(head));

        head = new BinaryTreeNode(5);
        assertTrue(binaryTreeOperations.isBST(head));

        assertTrue(binaryTreeOperations.isBST(null));
    }

    @Test (expected = Exception.class)
    public void testGetMinForBadInput() throws Exception {
        binaryTreeOperations.getMin(null);
    }

    @Test
    public void testGetMinForNoLeftTree() throws Exception {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.setRight(new BinaryTreeNode(2));

        BinaryTreeNode minNode = binaryTreeOperations.getMin(node);

        assertEquals(node, minNode);
    }

    @Test
    public void testGetMinForValidLeftTree() throws Exception {
        BinaryTreeNode node = new BinaryTreeNode(3);
        BinaryTreeNode lowestNode = new BinaryTreeNode(1);
        node.setLeft(new BinaryTreeNode(2));
        node.getLeft().setLeft(lowestNode);

        BinaryTreeNode minNode = binaryTreeOperations.getMin(node);

        assertEquals(lowestNode, minNode);
    }

    @Test
    public void testGetInorderSuccessorForBadInput() throws Exception {
        assertNull(binaryTreeOperations.getInorderSuccessor(null));
    }

    @Test
    public void testGetInorderSuccessorForNodeWithRightTree() throws Exception {
        BinaryTreeNode parent = new BinaryTreeNode(8);
        BinaryTreeNode inorderSuccessor = new BinaryTreeNode(9);
        parent.setRight(new BinaryTreeNode(10));
        parent.getRight().setLeft(inorderSuccessor);

        BinaryTreeNode actual = binaryTreeOperations.getInorderSuccessor(parent);

        assertNotNull(actual);
        assertEquals(inorderSuccessor, actual);
    }

    @Test
    public void testGetInorderSuccessorForNodeWithNoParentAndNoRightTree() throws Exception {
        BinaryTreeNode parent = new BinaryTreeNode(2);
        assertNull(binaryTreeOperations.getInorderSuccessor(parent));
    }

    @Test
    public void testGetInorderSuccessorForNodeWithLeftParent() throws Exception {
        BinaryTreeNode parent = new BinaryTreeNode(10);
        BinaryTreeNode child1 = new BinaryTreeNode(8);

        parent.setLeft(child1);
        child1.setParent(parent);

        BinaryTreeNode actual = binaryTreeOperations.getInorderSuccessor(child1);
        assertEquals(parent, actual);


        // now test node which appears on the right of its parent
        BinaryTreeNode child2 = new BinaryTreeNode(9);
        child1.setRight(child2);
        child2.setParent(child1);
        actual = binaryTreeOperations.getInorderSuccessor(child2);
        assertEquals(parent, actual);
    }

    //Common Ancestor is solved for a Binary Tree NOT Binary Search Tree
    @Test
    public void testGetCommonAncestorForInvalidInputs() {
        BinaryTreeNode node = new BinaryTreeNode(1);

        assertNull(binaryTreeOperations.getCommonAncestor(null, null, null));
        assertNull(binaryTreeOperations.getCommonAncestor(node, null, null));
        assertNull(binaryTreeOperations.getCommonAncestor(null, node, null));
        assertNull(binaryTreeOperations.getCommonAncestor(null, null, node));
    }

    @Test
    public void testGetCommonAncestorForNotExistingNodes() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode child1 = new BinaryTreeNode(2);
        BinaryTreeNode child2 = new BinaryTreeNode(3);

        root.setLeft(new BinaryTreeNode(9));

        // Root does not have child1 nor child2
        assertNull(binaryTreeOperations.getCommonAncestor(root, child1, child2));

        // Root has only child1
        root.getLeft().setRight(child1);
        assertNull(binaryTreeOperations.getCommonAncestor(root, child1, child2));

        // Root has only child2
        root.getLeft().setRight(child2);
        assertNull(binaryTreeOperations.getCommonAncestor(root, child1, child2));
    }

    @Test
    public void testGetCommonAncestorWhenChild1AndChild2AreOnSameSide() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode child1 = new BinaryTreeNode(2);
        BinaryTreeNode child2 = new BinaryTreeNode(3);
        BinaryTreeNode child3 = new BinaryTreeNode(4);

        root.setRight(child1);
        child1.setRight(child2);
        child2.setRight(child3);

        BinaryTreeNode CommonAncestor = binaryTreeOperations.getCommonAncestor(root, child2, child3);

        assertNotNull(CommonAncestor);
        assertEquals(child1, CommonAncestor);
    }

    @Test
    public void testGetCommonAncestorWhenChild1AndChild2AreOnDifferentSide() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode child1 = new BinaryTreeNode(2);
        BinaryTreeNode child2 = new BinaryTreeNode(3);
        BinaryTreeNode child3 = new BinaryTreeNode(4);
        BinaryTreeNode child4 = new BinaryTreeNode(5);

        root.setLeft(child1);
        root.setRight(child2);

        child1.setRight(child3);
        child2.setLeft(child4);

        BinaryTreeNode CommonAncestor = binaryTreeOperations.getCommonAncestor(root, child2, child3);

        assertNotNull(CommonAncestor);
        assertEquals(root, CommonAncestor);

    }

    @Test
    public void testGetCommonAncestorWhenOnlyChild1AndChild2AreInTree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode child1 = new BinaryTreeNode(2);

        root.setLeft(child1);

        BinaryTreeNode CommonAncestor = binaryTreeOperations.getCommonAncestor(root, root, child1);

        assertNotNull(CommonAncestor);
        assertEquals(root, CommonAncestor);
    }

    @Test
    public void testIsIdenticalForValidValues() {
        BinaryTreeNode tree1 = new BinaryTreeNode(8);
        BinaryTreeNode tree2 = new BinaryTreeNode(8);

        assertTrue(binaryTreeOperations.isIdentical(null, null));
        assertTrue(binaryTreeOperations.isIdentical(tree1, tree2));

        tree1.setLeft(new BinaryTreeNode(7));
        tree2.setLeft(new BinaryTreeNode(7));
        tree1.setRight(new BinaryTreeNode(9));
        tree2.setRight(new BinaryTreeNode(9));

        assertTrue(binaryTreeOperations.isIdentical(tree1, tree2));

        tree1.getRight().setRight(new BinaryTreeNode(10));
        tree2.getRight().setRight(new BinaryTreeNode(10));
        assertTrue(binaryTreeOperations.isIdentical(tree1, tree2));
    }

    @Test
    public void testIsIdenticalForInvalidValues() {
        BinaryTreeNode tree1 = new BinaryTreeNode(8);
        assertFalse(binaryTreeOperations.isIdentical(tree1, null));

        BinaryTreeNode tree2 = new BinaryTreeNode(8);
        tree2.setRight(new BinaryTreeNode(9));
        assertFalse(binaryTreeOperations.isIdentical(tree1, null));
    }

    @Test
    public void testSubTreeForInvalidValues() {
        assertFalse(binaryTreeOperations.isSubTree(null, null));

        BinaryTreeNode tree1 = new BinaryTreeNode(1);
        assertTrue(binaryTreeOperations.isSubTree(tree1, null));

        assertFalse(binaryTreeOperations.isSubTree(null, tree1));

        BinaryTreeNode tree2 = new BinaryTreeNode(4);
        tree2.setLeft(new BinaryTreeNode(4));
        tree2.setRight(new BinaryTreeNode(8));

        assertFalse(binaryTreeOperations.isSubTree(tree1, tree2));
    }

    @Test
    public void testSubTreeForValidValues() {
        BinaryTreeNode tree2 = new BinaryTreeNode(4);
        tree2.setLeft(new BinaryTreeNode(4));
        tree2.setRight(new BinaryTreeNode(8));

        assertTrue(binaryTreeOperations.isSubTree(tree2, tree2));


        BinaryTreeNode tree1 = new BinaryTreeNode(9);
        tree1.setLeft(new BinaryTreeNode(4));
        tree1.getLeft().setLeft(tree2);

        assertTrue(binaryTreeOperations.isSubTree(tree1, tree2));
    }


    @Test
    public void testsGetAllPathsWithSumForGivenNodeWithInvalidInputs() {
        List<List<BinaryTreeNode>> results = binaryTreeOperations.getAllPathsWithSumForGivenNode(null, 0, 0, null);
        assertNotNull(results);
        assertTrue(results.isEmpty());

        results = binaryTreeOperations.getAllPathsWithSumForGivenNode(new BinaryTreeNode(0), 0, 0, null);
        assertNotNull(results);
        assertTrue(results.isEmpty());
    }


    @Test
    public void canGetAllPathsWithSumForGivenNode() {
        BinaryTreeNode root = new BinaryTreeNode(9);
        int sum = root.getValue();

        List<List<BinaryTreeNode>> results = binaryTreeOperations.getAllPathsWithSumForGivenNode(root, sum, 0, new ArrayList<BinaryTreeNode>());
        assertNotNull(results);
        assertFalse(results.isEmpty());
        assertTrue(isValidResult(results, sum));

        root.setLeft(new BinaryTreeNode(5));
        root.setRight(new BinaryTreeNode(20));
        sum = root.getValue() + root.getRight().getValue();

        results = binaryTreeOperations.getAllPathsWithSumForGivenNode(root, sum, 0, new ArrayList<BinaryTreeNode>());
        assertNotNull(results);
        assertFalse(results.isEmpty());
        assertTrue(isValidResult(results, sum));

        root.getLeft().setRight(new BinaryTreeNode(7));
        root.getLeft().getRight().setRight(new BinaryTreeNode(-7));
        sum = root.getValue() + root.getLeft().getValue();
        results = binaryTreeOperations.getAllPathsWithSumForGivenNode(root, sum, 0, new ArrayList<BinaryTreeNode>());
        assertNotNull(results);
        assertFalse(results.isEmpty());
        assertTrue(isValidResult(results, sum));

    }

    @Test
    public void cannotGetAllPathsWithSumForGivenNode() {
        BinaryTreeNode root = new BinaryTreeNode(9);
        int sum = root.getValue() + 1;

        List<List<BinaryTreeNode>> results = binaryTreeOperations.getAllPathsWithSumForGivenNode(root, sum, 0, new ArrayList<BinaryTreeNode>());
        assertNotNull(results);
        assertTrue(results.isEmpty());
        assertFalse(isValidResult(results, sum));

        root.setLeft(new BinaryTreeNode(2));
        root.getLeft().setRight(new BinaryTreeNode(6));
        sum = Integer.MAX_VALUE;
        results = binaryTreeOperations.getAllPathsWithSumForGivenNode(root, sum, 0, new ArrayList<BinaryTreeNode>());
        assertNotNull(results);
        assertTrue(results.isEmpty());
        assertFalse(isValidResult(results, sum));
    }

    @Test
    public void cannotGetAllPathsWithSum() {
        List<List<BinaryTreeNode>> results = binaryTreeOperations.getAllPathsWithSum(null, 0);
        assertNotNull(results);
        assertTrue(results.isEmpty());
        assertFalse(isValidResult(results, 0));

        BinaryTreeNode root = new BinaryTreeNode(10);
        results = binaryTreeOperations.getAllPathsWithSum(root, 0);
        assertNotNull(results);
        assertTrue(results.isEmpty());
        assertFalse(isValidResult(results, 0));


        root.setLeft(new BinaryTreeNode(-1));
        root.setRight(new BinaryTreeNode(11));
        results = binaryTreeOperations.getAllPathsWithSum(root, 0);
        assertNotNull(results);
        assertTrue(results.isEmpty());
        assertFalse(isValidResult(results, 0));


        root.getRight().setRight(new BinaryTreeNode(20));
        root.getLeft().setRight(new BinaryTreeNode(8));
        results = binaryTreeOperations.getAllPathsWithSum(root, 0);
        assertNotNull(results);
        assertTrue(results.isEmpty());
        assertFalse(isValidResult(results, 0));
    }

    @Test
    public void canGetAllPathsWithSum() {
        BinaryTreeNode root = new BinaryTreeNode(20);
        root.setLeft(new BinaryTreeNode(2));
        root.setRight(new BinaryTreeNode(22));

        int sum = root.getValue() + root.getLeft().getValue();
        List<List<BinaryTreeNode>> results = binaryTreeOperations.getAllPathsWithSum(root, sum);
        assertNotNull(results);
        assertTrue(isValidResult(results, sum));

        root.getLeft().setRight(new BinaryTreeNode(5));
        sum = root.getLeft().getValue() + root.getLeft().getRight().getValue();
        results = binaryTreeOperations.getAllPathsWithSum(root, sum);
        assertNotNull(results);
        assertTrue(isValidResult(results, sum));

        root.getLeft().getRight().setRight(new BinaryTreeNode(0));
        results = binaryTreeOperations.getAllPathsWithSum(root, sum);
        assertNotNull(results);
        assertTrue(isValidResult(results, sum));
    }

    private boolean isValidResult(List<List<BinaryTreeNode>> results, int sum) {
        if (results == null || results.isEmpty()) {
            return false;
        }

        for (List<BinaryTreeNode> resultList : results) {
            int count = 0;
            for (BinaryTreeNode node : resultList) {
                count += node.getValue();
            }
            if (count != sum) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void canGetNodeListAtAllDepths() {
        BinaryTreeNode root = new BinaryTreeNode(4);
        BinaryTreeNode level1Child1 = new BinaryTreeNode(2);
        root.setLeft(level1Child1);
        BinaryTreeNode level1Child2 = new BinaryTreeNode(7);
        root.setRight(level1Child2);

        BinaryTreeNode level2child1 = new BinaryTreeNode(1);
        level1Child1.setLeft(level2child1);
        BinaryTreeNode level2child2 = new BinaryTreeNode(3);
        level1Child1.setRight(level2child2);
        BinaryTreeNode level2child3 = new BinaryTreeNode(5);
        level1Child2.setLeft(level2child3);

        BinaryTreeNode level3Child1 = new BinaryTreeNode(6);
        level2child3.setRight(level3Child1);

        List<List<BinaryTreeNode>> results = binaryTreeOperations.getNodeListAtDepths(root);
        assertTrue(results.size() == 4);
        assertTrue(results.get(0).size() == 1);
        assertTrue(results.get(0).contains(root));

        assertTrue(results.get(1).size() == 2);
        assertTrue(results.get(1).contains(level1Child1));
        assertTrue(results.get(1).contains(level1Child2));

        assertTrue(results.get(2).size() == 3);
        assertTrue(results.get(2).contains(level2child1));
        assertTrue(results.get(2).contains(level2child2));
        assertTrue(results.get(2).contains(level2child3));

        assertTrue(results.get(3).size() == 1);
        assertTrue(results.get(3).contains(level3Child1));
    }
}
