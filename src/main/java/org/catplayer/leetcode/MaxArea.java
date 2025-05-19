package org.catplayer.leetcode;

/**
 * 盛最多水的容器
 * <p>
 * 该算法的核心思想是 x 轴尽可能往后移
 */
public class MaxArea {

    public int maxArea(int[] height) {

        if (height.length <= 1) {
            return 0;
        }

        var start = 0;
        var end = 1;

        // try to get the next one
        for (int i = 2; i < height.length; i++) {

            var current = height[i];
            var startHeight = height[start];
            var endHeight = height[end];

            // calculate 2 area to compare

            var startToCurrent = Math.min(current, startHeight) * (i - start);
            var endToCurrent = Math.min(current, endHeight) * (i - end);
            var startToEnd = Math.min(startHeight, endHeight) * (end - start);

            if (startToEnd >= startToCurrent && startToEnd >= endToCurrent) {
                continue;
            }

            if (startToCurrent >= endToCurrent) {
                end = i;
                continue;
            }

            start = end;
            end = i;
        }


        return Math.min(height[start], height[end]) * (end - start);
    }


}
