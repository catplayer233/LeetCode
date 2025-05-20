package org.catplayer.leetcode.test;

import org.catplayer.leetcode.ThreeSum;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSumTest {

    @Test
    public void test() {
        assertThreeSum(new int[][]{{-1, -1, 2}, {-1, 0, 1}}, new int[]{-1, 0, 1, 2, -1, -4});
        assertThreeSum(new int[0][0], new int[]{0, 1, 1});
        assertThreeSum(new int[][]{{0, 0, 0}}, new int[]{0, 0, 0});
    }

    private void assertThreeSum(int[][] expect, int[] target) {
        var results = ThreeSum.threeSum(target);

        // check the value
        var expectInternal = Arrays.stream(expect).map(ThreeSumValue::valueOf).collect(Collectors.toSet());
        var actualInternal = results.stream().map(ThreeSumValue::valueOf).collect(Collectors.toSet());

        // formatted
        if (results.size() != actualInternal.size()) {
            throw new AssertionFailedError("size is not same, origin: [%d], actual: [%d]".formatted(results.size(), actualInternal.size()));
        }


        // actual and expect
        if (actualInternal.size() != expectInternal.size()) {
            throw new AssertionFailedError("size is not same, expect: [%d], actual: [%d]".formatted(expectInternal.size(), actualInternal.size()));
        }

        // all values
        if (!expectInternal.containsAll(actualInternal)) {
            throw new AssertionFailedError("value is not same, expect: [%s], actual: [%s]".formatted(expectInternal, actualInternal));
        }

    }
}

record ThreeSumValue(int first, int second, int third) {

    public static ThreeSumValue valueOf(List<Integer> value) {
        var sortedList = value.stream().sorted().toList();

        return new ThreeSumValue(sortedList.get(0), sortedList.get(1), sortedList.get(2));
    }

    public static ThreeSumValue valueOf(int[] value) {
        return valueOf(List.of(value[0], value[1], value[2]));
    }
}
