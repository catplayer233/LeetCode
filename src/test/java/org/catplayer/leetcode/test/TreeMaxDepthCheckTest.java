package org.catplayer.leetcode.test;

import org.catplayer.leetcode.TreeMaxDepthChecker;
import org.catplayer.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreeMaxDepthCheckTest {

    @Test
    public void checkMaxDepth() {
        Assertions.assertEquals(3, TreeMaxDepthChecker.checkMaxDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));

        Assertions.assertEquals(2, TreeMaxDepthChecker.checkMaxDepth(new TreeNode(1, null, new TreeNode(2))));
    }
}
