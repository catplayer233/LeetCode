package org.catplayer.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked">三数之和</a>
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        /*
         * [-1,0,1,2,-1,-4]
         * 通过两个即可确定一个
         * 如果当前的已经检索完就不需要再进行检索了，因为结果已经确定了
         * */
        // 0. sorted, so we can use fast search algorithm for the third num
        Arrays.sort(nums);
        var results = new HashMap<Integer, HashMap<Integer, Integer>>();

        for (var i = 0; i < nums.length - 2; i++) {
            // try to search
            int first = nums[i];

            // already searched, skip
            if (results.containsKey(first)) {
                continue;
            }

            var currentResult = new HashMap<Integer, Integer>();

            for (var j = i + 1; j < nums.length - 1; j++) {
                var second = nums[j];
                var expectThird = -(first + second);

                // already search in global
                if (results.containsKey(second) || results.containsKey(expectThird)) {
                    continue;
                }

                // already search in current session
                if (currentResult.containsKey(second) || currentResult.containsKey(expectThird)) {
                    continue;
                }

                if (Arrays.binarySearch(nums, j + 1, nums.length, expectThird) >= 0) {
                    currentResult.put(second, expectThird);
                }
            }

            // only track not empty
            if (!currentResult.isEmpty()) {
                results.put(first, currentResult);
            }

        }

        return results
                .entrySet()
                .stream()
                .flatMap(it -> it.getValue()
                        .entrySet()
                        .stream()
                        .map(entry -> {
                            List<Integer> current = new ArrayList<>();
                            current.add(it.getKey());
                            current.add(entry.getKey());
                            current.add(entry.getValue());
                            return current;
                        }))
                .toList();
    }
}
