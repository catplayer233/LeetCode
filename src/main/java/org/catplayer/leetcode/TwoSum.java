package org.catplayer.leetcode;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        var holder = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++) {
            var num = nums[i];
            var matchedValue = target - num;
            var matchedIndex = holder.get(matchedValue);
            if (matchedIndex != null) {
                return new int[]{matchedIndex, i};
            }

            holder.put(num, i);
        }


        return new int[]{-1, -1};
    }
}
