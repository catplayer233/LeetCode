package org.catplayer.leetcode

import kotlin.test.Test

class ZeroesMoveTest {

    private val move = ZeroesMove()

    @Test
    fun `test move zeroes`() {
        moveAndPrint(intArrayOf(0, 1, 0, 3, 12))
        moveAndPrint(intArrayOf(0))
    }


    private fun moveAndPrint(nums: IntArray) {
        println(nums.joinToString(",", prefix = "[", postfix = "]"))
        move.moveZeroes(nums)
        println(nums.joinToString(",", prefix = "[", postfix = "]"))
    }
}