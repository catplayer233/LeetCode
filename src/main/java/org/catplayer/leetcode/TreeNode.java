package org.catplayer.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this(val, null, null);
    }

    public TreeNode(int val, TreeNode left) {
        this(val, left, null);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
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

    public String toBreadthString() {
        var nodes = new ArrayList<TreeNode>();
        nodes.add(this);

        var stringBuilder = new StringBuilder();
        for (; ; ) {
            var refreshNodes = new ArrayList<TreeNode>();
            for (var node : nodes) {
                if (node == null) {
                    stringBuilder.append("null").append(",");
                    refreshNodes.add(null);
                    refreshNodes.add(null);
                } else {
                    stringBuilder.append(node.val).append(",");
                    refreshNodes.add(node.left);
                    refreshNodes.add(node.right);
                }
            }

            if (refreshNodes.stream().allMatch(Objects::isNull)) {
                break;
            }

            nodes = refreshNodes;
        }

        stringBuilder.setLength(stringBuilder.length() - 1);
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