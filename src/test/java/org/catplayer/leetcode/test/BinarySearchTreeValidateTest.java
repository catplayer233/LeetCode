package org.catplayer.leetcode.test;

import org.catplayer.leetcode.BinarySearchTreeValidator;
import org.catplayer.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeValidateTest {
    @Test
    public void test() {

        // [2,1,3]
        Assertions.assertTrue(BinarySearchTreeValidator.isValid(new TreeNode(2, new TreeNode(1), new TreeNode(3))));

        // [5,1,4,null,null,3,6]
        Assertions.assertFalse(
                BinarySearchTreeValidator.isValid(
                        new TreeNode(
                                5,
                                new TreeNode(1),
                                new TreeNode(
                                        4,
                                        new TreeNode(3),
                                        new TreeNode(6)
                                )
                        )
                )
        );

        // [2,2,2]
        Assertions.assertFalse(BinarySearchTreeValidator.isValid(new TreeNode(2, new TreeNode(2), new TreeNode(2))));

        //[5,4,6,null,null,3,7]
        Assertions.assertFalse(
                BinarySearchTreeValidator.isValid(
                        new TreeNode(
                                5,
                                new TreeNode(4),
                                new TreeNode(
                                        6,
                                        new TreeNode(3),
                                        new TreeNode(7)
                                )
                        )
                )
        );

    }
}
