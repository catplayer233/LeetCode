package org.catplayer.leetcode.test;

import org.catplayer.leetcode.SortArrayBSTTransformer;
import org.junit.jupiter.api.Test;

public class SortArrayBSTTransformTest {

    @Test
    public void test() {
        System.out.println(SortArrayBSTTransformer.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}).toBreadthString());
        System.out.println(SortArrayBSTTransformer.sortedArrayToBST(new int[]{1, 3}).toBreadthString());
    }
}
