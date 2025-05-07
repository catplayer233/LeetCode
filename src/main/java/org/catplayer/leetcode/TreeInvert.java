package org.catplayer.leetcode;

public class TreeInvert {

    public TreeNode invert(TreeNode treeNode) {

        if (treeNode == null) {
            return null;
        }

        var left = treeNode.left;
        treeNode.left = invert(treeNode.right);
        treeNode.right = invert(left);

        return treeNode;
    }
}



