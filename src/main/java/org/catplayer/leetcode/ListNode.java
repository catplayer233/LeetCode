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

    public static ListNode buildNode(int... value) {
        return buildNode(value, null);
    }

    // internal used, we don't concern empty array problem, at least has one element for testing
    public static ListNode buildNode(int[] value, ListNode tailNode) {
        var head = new ListNode(value[0]);

        var next = head;
        for (int i = 1; i < value.length; i++) {
            next = next.next(new ListNode(value[i]));
        }

        if (tailNode != null) {
            next.next(tailNode);
        }

        return head;
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
