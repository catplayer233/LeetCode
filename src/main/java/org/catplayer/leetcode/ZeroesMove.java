package org.catplayer.leetcode;

public class ZeroesMove {

    /**
     * [ 0,1,0,3,12 ]
     */
    public void moveZeroes(int[] nums) {

        if (nums.length <= 1) {
            return;
        }

        var start = 0;
        for (var end = 1; end < nums.length; end++) {

            var startNum = nums[start];
            var endNum = nums[end];

            if (startNum != 0) {
                start++;
                continue;
            }

            if (endNum == 0) {
                continue;
            }

            swap(nums, start, end);
            start++;

        }

    }

    private void swap(int[] nums, int index1, int index2) {
        var tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
