package org.catplayer.leetcode.test;

import org.catplayer.leetcode.MaxArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxAreaTest {

    @Test
    public void testMaxArea() {
        assertMaxArea(0, new int[]{1});
        assertMaxArea(49, new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        assertMaxArea(4, new int[]{1, 2, 4, 3});
        assertMaxArea(1, new int[]{1, 1});
        assertMaxArea(70, new int[]{0, 14, 6, 2, 10, 9, 4, 1, 10, 3});
    }

    private void assertMaxArea(int value, int[] height) {
        Assertions.assertEquals(value, MaxArea.maxArea(height));
    }
}
