package org.catplayer.leetcode.test;

import org.catplayer.leetcode.ListNode;
import org.catplayer.leetcode.NodeIntersectionGet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NodeIntersectionGetTest {

    @Test
    public void test() {
        var expectedNode = ListNode.buildNode(8, 4, 5);
        var headA = ListNode.buildNode(new int[]{4, 1}, expectedNode);
        var headB = ListNode.buildNode(new int[]{5, 6, 1}, expectedNode);

        System.out.println(headA);
        System.out.println(headB);

        assertGetNodeIntersection(headA, headB, expectedNode);
    }

    private void assertGetNodeIntersection(ListNode headA, ListNode headB, ListNode expectedNode) {
        Assertions.assertSame(expectedNode, NodeIntersectionGet.getIntersectionNode(headA, headB));
    }
}
