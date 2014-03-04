public class BinaryTreeOperations {

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
}
