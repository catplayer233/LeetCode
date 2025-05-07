package org.catplayer.leetcode;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 中序遍历: 左->根->右
     */
    public List<Integer> toMiddleOrderList() {

        var result = new ArrayList<Integer>();
        toMiddleOrderList(result, this);
        return result;
    }

    private static void toMiddleOrderList(List<Integer> result, TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        // 左节点
        toMiddleOrderList(result, treeNode.left);
        // 根节点
        result.add(treeNode.val);
        // 右节点
        toMiddleOrderList(result, treeNode.right);
    }

    public String toMiddleOrderString() {
        return String.join(",", toMiddleOrderList().stream().map(Object::toString).toList());
    }
}