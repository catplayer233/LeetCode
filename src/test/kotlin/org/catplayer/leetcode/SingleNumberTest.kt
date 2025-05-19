package org.catplayer.leetcode

import kotlin.test.Test
import kotlin.test.assertEquals

class SingleNumberTest {

    @Test
    fun `test single number`() {

        val array = intArrayOf(1)

        assertEquals(1, SingleNumber().singleNum(array))

    }
}