package org.catplayer.leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode next(ListNode nextNode) {
        next = nextNode;

        return next;
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder("[");
        stringBuilder.append(val);

        var currentNext = next;

        while (currentNext != null) {
            stringBuilder.append(",");
            stringBuilder.append(currentNext.val);
            currentNext = currentNext.next;
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
