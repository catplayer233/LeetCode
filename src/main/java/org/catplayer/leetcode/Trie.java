package org.catplayer.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 前缀树
 */
public class Trie {

    private final TrieNode root;


    public Trie() {
        root = TrieNode.Empty();

    }

    public void insert(String word) {

        // avoid npe
        if (word == null || word.isEmpty()) {
            return;
        }

        var trieResult = searchNode(word);

        if (trieResult.matched()) {
            return;
        }

        var trieNode = trieResult.mostMatchedNode();

        for (var i = trieResult.nextIndex(); i < word.length(); i++) {
            trieNode = trieNode.addChild(word.charAt(i));
        }
    }

    public boolean search(String word) {
        return searchNode(word).matched();
    }

    private TrieResult searchNode(String word) {

        var index = 0;
        var node = root;
        var matched = true;
        while (index < word.length()) {
            var currentChar = word.charAt(index);

            var currentMatched = false;
            for (var child : node.children) {
                if (child.val == currentChar) {
                    node = child;
                    currentMatched = true;
                    break;
                }
            }

            if (!currentMatched) {
                matched = false;
                break;
            }

            index++;
        }

        return new TrieResult(matched, node, index);
    }

}

class TrieNode {
    final char val;
    final List<TrieNode> children = new ArrayList<>();

    private TrieNode(char val) {
        this.val = val;
    }

    static TrieNode Empty() {
        return new TrieNode('\0');
    }

    static TrieNode WithChar(char val) {
        return new TrieNode(val);
    }

    TrieNode addChild(char val) {
        children.add(WithChar(val));
        return children.getLast();
    }
}

/**
 * if the result matched, the mostMatchedNode is the last char node, otherwise is the most matched char node
 *
 * @param matched
 * @param mostMatchedNode
 */
record TrieResult(boolean matched, TrieNode mostMatchedNode, int nextIndex) {
}

