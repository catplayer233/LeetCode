package org.catplayer.leetcode;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {

        var stringBuilder = new StringBuilder();

        stringBuilder.append(val);

        if (left != null) {
            stringBuilder.append(",").append(left);
        }

        if (right != null) {
            stringBuilder.append(",").append(right);
        }

        return stringBuilder.toString();
    }
}