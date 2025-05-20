package org.catplayer.leetcode;

/**
 * 盛最多水的容器
 * <p>
 */
public class MaxArea {

    /**
     * 双指针移动，一个指向首端，一个指向末端，每次尝试移动height小的一侧，直至两个指针重叠，
     */
    public static int maxArea(int[] height) {
        var left = 0;
        var right = height.length - 1;

        var max = 0;


        while (left < right) {

            int leftHeight = height[left];
            int rightHeight = height[right];
            max = Math.max(Math.min(leftHeight, rightHeight) * (right - left), max);

            if (leftHeight <= rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

}
