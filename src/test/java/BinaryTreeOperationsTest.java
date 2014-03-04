import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeOperationsTest {

    private BinaryTreeOperations binaryTreeOperations = new BinaryTreeOperations();

    @Test
    public void testGetHeightWhenTreeIsBalanced() {
        BinaryTreeNode head = new BinaryTreeNode();
        head.setValue(1);

        BinaryTreeNode leftNode = new BinaryTreeNode();
        leftNode.setValue(2);

        BinaryTreeNode rightNode = new BinaryTreeNode();
        rightNode.setValue(3);

        head.setLeft(leftNode);
        head.setRight(rightNode);

        assertTrue(binaryTreeOperations.isBalanced(head));
    }

    @Test
    public void testGetHeightWhenOnlyOneNode() {
        BinaryTreeNode head = new BinaryTreeNode();
        head.setValue(1);

        assertTrue(binaryTreeOperations.isBalanced(head));
    }

    @Test
    public void testGetHeightWhenOneSideWithMoreNumberOfNode() {
        BinaryTreeNode head = new BinaryTreeNode();
        head.setValue(1);

        BinaryTreeNode leftNode = new BinaryTreeNode();
        leftNode.setValue(2);
        head.setLeft(leftNode);

        BinaryTreeNode left2Node = new BinaryTreeNode();
        left2Node.setValue(3);
        leftNode.setLeft(left2Node);

        assertFalse(binaryTreeOperations.isBalanced(head));
    }

}
