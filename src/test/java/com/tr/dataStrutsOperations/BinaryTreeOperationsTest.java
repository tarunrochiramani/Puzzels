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

}
