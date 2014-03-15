package com.tr.dataStrutsOperations;

import com.tr.datastruts.BinaryTreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

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
}
