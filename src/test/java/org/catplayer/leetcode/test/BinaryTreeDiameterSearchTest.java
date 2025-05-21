package org.catplayer.leetcode.test;

import org.catplayer.leetcode.BinaryTreeDiameterSearcher;
import org.catplayer.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeDiameterSearchTest {
    @Test
    public void test() {
        Assertions.assertEquals(
                3,
                BinaryTreeDiameterSearcher.diameterOfBinaryTree(
                        new TreeNode(
                                1,
                                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                                new TreeNode(3)
                        )
                )
        );

        Assertions.assertEquals(
                1,
                BinaryTreeDiameterSearcher.diameterOfBinaryTree(
                        new TreeNode(
                                1,
                                new TreeNode(2)
                        )
                ));
    }
}
