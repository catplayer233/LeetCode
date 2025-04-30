package org.catplayer.leetcode

import kotlin.test.Test
import kotlin.test.assertTrue

class TrieTest {

    private val trie = Trie()

    @Test
    fun `test trie`() {

        val word = "hello"
        trie.insert(word)

        assertTrue {
            trie.search("hello")
        }
    }
}