package org.catplayer.leetcode.test;

import org.catplayer.leetcode.TreeLevelOrder;
import org.catplayer.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TreeLevelOrderTest {

    @Test
    public void test() {

        Assertions.assertEquals(
                List.of(
                        List.of(3),
                        List.of(9, 20),
                        List.of(15, 7)
                ),
                TreeLevelOrder.levelOrder(
                        new TreeNode(
                                3,
                                new TreeNode(9),
                                new TreeNode(
                                        20,
                                        new TreeNode(15),
                                        new TreeNode(7)
                                )
                        )
                )
        );

        Assertions.assertEquals(
                List.of(List.of(1)),
                TreeLevelOrder.levelOrder(new TreeNode(1))
        );

        Assertions.assertEquals(List.of(), TreeLevelOrder.levelOrder(null));
    }
}
