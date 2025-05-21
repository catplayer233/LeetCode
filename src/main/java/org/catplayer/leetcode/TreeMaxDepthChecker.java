package org.catplayer.leetcode;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=top-100-liked">二叉树的最大深度</a>
 */
public class TreeMaxDepthChecker {

    public static int checkMaxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(checkMaxDepth(root.left), checkMaxDepth(root.right));
    }
}
