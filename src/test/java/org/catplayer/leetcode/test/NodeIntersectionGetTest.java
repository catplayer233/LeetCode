package org.catplayer.leetcode.test;

import org.catplayer.leetcode.ListNode;
import org.catplayer.leetcode.NodeIntersectionGet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NodeIntersectionGetTest {

    @Test
    public void test() {
        var expectedNode = buildNode(new int[]{8, 4, 5});
        var headA = buildNode(new int[]{4, 1}, expectedNode);
        var headB = buildNode(new int[]{5, 6, 1}, expectedNode);

        System.out.println(headA);
        System.out.println(headB);

        assertGetNodeIntersection(headA, headB, expectedNode);
    }

    private void assertGetNodeIntersection(ListNode headA, ListNode headB, ListNode expectedNode) {
        Assertions.assertSame(expectedNode, NodeIntersectionGet.getIntersectionNode(headA, headB));
    }


    private static ListNode buildNode(int[] value) {
        return buildNode(value, null);
    }

    // internal used, we don't concern empty array problem, at least has one element for testing
    private static ListNode buildNode(int[] value, ListNode tailNode) {
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
}
