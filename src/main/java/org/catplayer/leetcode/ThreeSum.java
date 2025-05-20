package org.catplayer.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked">三数之和</a>
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        /*
         * [-1,0,1,2,-1,-4]
         * 两个确定一个
         * 如果当前的已经检索完就不需要再进行检索了，因为结果已经确定了
         * */
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

                for (var k = j + 1; k < nums.length; k++) {
                    var third = nums[k];
                    if (expectThird == third) {
                        currentResult.put(second, third);
                        break;
                    }
                }
            }

            results.put(first, currentResult);
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
