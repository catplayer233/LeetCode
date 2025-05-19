package org.catplayer.leetcode

import kotlin.test.Test
import kotlin.test.assertEquals

class MaxAreaTest {

    @Test
    fun `test max area`() {

        val array = intArrayOf(1, 1)
        assertEquals(1, MaxArea().maxArea(array))

    }
}