package org.catplayer.leetcode;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    // pwwkew
    public static int lengthOfLongestSubstring(String s) {

        var noRepeatCharacterMap = new HashMap<Integer, Integer>();

        var maxLength = 0;

        var currentLength = 0;

        for (var i = 0; i < s.length(); i++) {
            int currentChar = s.charAt(i);
            var repeatedIndex = noRepeatCharacterMap.get(currentChar);

            noRepeatCharacterMap.put(currentChar, i);
            if (repeatedIndex == null) {
                currentLength++;
            } else {

                //

            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
