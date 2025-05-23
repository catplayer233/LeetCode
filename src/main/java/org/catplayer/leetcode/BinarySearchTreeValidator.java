package org.catplayer.leetcode;

/**
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked">验证二叉搜索树</a>
 */
public class BinarySearchTreeValidator {

    public static boolean isValid(TreeNode root) {

        // 核心思想是：左节点所有子节点要小于根节点，右节点所有子节点要大于根节点
        // 1. check self
        if (root == null) {
            return true;
        }

        var val = root.val;

        // 2. check left
        if (!isValid(root.left)) {
            return false;
        }

        if (root.left != null && getMostValue(root.left, false) >= val) {
            return false;
        }

        // 3. check right
        if (!isValid(root.right)) {
            return false;
        }

        return root.right == null || getMostValue(root.right, true) > val;
    }

    private static int getMostValue(TreeNode root, boolean left) {

        if (left) {
            if (root.left == null) {
                return root.val;
            }

            return getMostValue(root.left, true);
        }

        if (root.right == null) {
            return root.val;
        }

        return getMostValue(root.right, false);
    }
}
