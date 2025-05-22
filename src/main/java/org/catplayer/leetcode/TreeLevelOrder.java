package org.catplayer.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-100-liked">二叉树的层序遍历</a>
 */
public class TreeLevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return List.of();
        }

        var result = new ArrayList<List<Integer>>();
        var nodes = new LinkedList<TreeNode>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            var vals = new ArrayList<Integer>();
            var currentSize = nodes.size();
            for (var i = 0; i < currentSize; i++) {
                // pop from head
                var node = nodes.poll();
                vals.add(node.val);

                // append to tail
                if (node.left != null) {
                    nodes.offer(node.left);
                }

                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }

            result.add(vals);
        }

        return result;
    }


}
