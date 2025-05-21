package org.catplayer.leetcode;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree/?envType=study-plan-v2&envId=top-100-liked">对称二叉树</a>
 */
public class SymmetricTreeChecker {
    public static boolean isSymmetric(TreeNode root) {
        // 广度遍历
//        return isSymmetricBreadth(root);

        // 深度遍历
        return isSymmetricDepth(root);
    }

    private static boolean isSymmetricBreadth(TreeNode root) {
        var scannedNodes = new ArrayList<TreeNode>();
        scannedNodes.add(root);

        for (; ; ) {
            var nextScannedNodes = new ArrayList<TreeNode>();
            for (var node : scannedNodes) {
                if (node != null) {
                    nextScannedNodes.add(node.left);
                    nextScannedNodes.add(node.right);
                } else {
                    nextScannedNodes.add(null);
                    nextScannedNodes.add(null);
                }
            }

            // make sure is same
            var allNull = true;
            for (int i = 0, j = nextScannedNodes.size() - 1; i < j; i++, j--) {
                var mostLeft = nextScannedNodes.get(i);
                var mostRight = nextScannedNodes.get(j);

                if ((mostLeft == null && mostRight == null)) {
                    continue;
                }

                if (mostLeft != null && mostRight != null && mostLeft.val == mostRight.val) {
                    allNull = false;
                    continue;
                }

                return false;
            }

            if (allNull) {
                return true;
            }

            scannedNodes = nextScannedNodes;
        }

    }

    private static boolean isSymmetricDepth(TreeNode root) {

        // most left == most right
        return isEquals(root.left, root.right);
    }

    private static boolean isEquals(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null && left.val == right.val) {
            return isEquals(left.left, right.right) && isEquals(left.right, right.left);
        }

        return false;
    }
}
