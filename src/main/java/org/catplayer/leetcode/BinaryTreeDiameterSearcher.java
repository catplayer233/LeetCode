package org.catplayer.leetcode;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked">二叉树的直径</a>
 */
public class BinaryTreeDiameterSearcher {
    public static int diameterOfBinaryTree(TreeNode root) {
        // track the max diameter
        var treeDiameter = new BinaryTreeDiameter();
        maxDepth(root, treeDiameter);
        return treeDiameter.getValue();
    }

    private static int maxDepth(TreeNode node, BinaryTreeDiameter diameter) {
        if (node == null) {
            return 0;
        }

        var leftDepth = maxDepth(node.left, diameter);
        var rightDepth = maxDepth(node.right, diameter);

        // check current node's diameter, make sure we always keep the max one
        diameter.update(leftDepth + rightDepth);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}

class BinaryTreeDiameter {
    private int value;

    public void update(int diameter) {
        value = Math.max(value, diameter);
    }

    public int getValue() {
        return value;
    }
}
