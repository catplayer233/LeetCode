package org.catplayer.leetcode

import kotlin.test.Test

class TreeInvertTest {

    @Test
    fun `test tree invert`() {
        val treeNode = TreeNode(
            4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(7, TreeNode(6), TreeNode(9))
        )

        println(treeNode)

        val treeInvert = TreeInvert()
        val invertedTreeNode = treeInvert.invert(treeNode)

        println(invertedTreeNode)
    }
}