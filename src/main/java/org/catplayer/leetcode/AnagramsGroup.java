package org.catplayer.leetcode;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramsGroup {

    public List<List<String>> groupAnagrams(String[] strs) {

        var result = new HashMap<String, List<String>>();

        for (var str : strs) {
            var sortedBytes = new byte[str.length()];
            var array = str.chars().sorted().toArray();
            for (var i = 0; i < array.length; i++) {
                var currentByte = (byte) (array[i] & 0xff);
                sortedBytes[i] = currentByte;
            }

            var sortedString = new String(sortedBytes, StandardCharsets.UTF_8);

            result.computeIfAbsent(sortedString, key -> new ArrayList<>()).add(str);
        }

        return result.values().stream().toList();
    }
}
