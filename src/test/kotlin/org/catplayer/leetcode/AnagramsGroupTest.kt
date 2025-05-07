package org.catplayer.leetcode

import kotlin.test.Test

class AnagramsGroupTest {

    @Test
    fun `test group anagrams`() {

        val anagramsGroup = AnagramsGroup()

        println(anagramsGroup.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
        println(anagramsGroup.groupAnagrams(arrayOf("")))
        println(anagramsGroup.groupAnagrams(arrayOf("a")))

    }
}