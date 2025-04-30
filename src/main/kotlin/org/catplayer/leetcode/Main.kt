package org.catplayer.leetcode


fun main() {

    val trie = Trie()

    println(trie.search("hello"))

    trie.insert("hello")

    println(trie.search("hello"))

    println(trie.search("hell"))

}