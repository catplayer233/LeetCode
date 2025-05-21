package org.catplayer.leetcode;

/**
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked">将有序数组转换为二叉搜索树</a>
 */
public class SortArrayBSTTransformer {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return transform(nums, 0, nums.length);
    }

    private static TreeNode transform(int[] nums, int fromIndex, int endIndex) {
        // 0  1 2 3 4
        // -10,-3,0,5,9
        if (fromIndex >= endIndex) {
            return null;
        }

        var middleIndex = (fromIndex + endIndex) / 2;

        return new TreeNode(
                nums[middleIndex],
                transform(nums, fromIndex, middleIndex),
                transform(nums, middleIndex + 1, endIndex)
        );
    }


}
