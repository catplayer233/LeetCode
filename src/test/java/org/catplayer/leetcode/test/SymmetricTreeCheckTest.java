package org.catplayer.leetcode.test;

import org.catplayer.leetcode.SymmetricTreeChecker;
import org.catplayer.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SymmetricTreeCheckTest {

    @Test
    public void test() {
        // 1,2,2,3,4,4,3 => true
        Assertions.assertTrue(SymmetricTreeChecker.isSymmetric(new TreeNode(
                1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)))
        ));

        // 1,2,2,null,3,null,3 => false
        Assertions.assertFalse(SymmetricTreeChecker.isSymmetric(new TreeNode(
                1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)))
        ));
    }
}
