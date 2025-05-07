package org.catplayer.leetcode

import kotlin.test.Test

class MiddleOrderTreeTest {

    @Test
    fun `test middle order`() {

        //1,null,2,3
        val treeNode = TreeNode(1, null, TreeNode(2, TreeNode(3), null))

        println(treeNode.toMiddleOrderString())

    }
}