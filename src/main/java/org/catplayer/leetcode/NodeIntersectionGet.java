package org.catplayer.leetcode;

import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/description/?envType=study-plan-v2&envId=top-100-liked">相交链表</a>
 */
public class NodeIntersectionGet {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        return getIntersectionNodeByHash(headA, headB);
        return getIntersectionNodeByCursor(headA, headB);
    }

    private static ListNode getIntersectionNodeByHash(ListNode headA, ListNode headB) {
        var listNodes = new HashSet<ListNode>();

        var next = headA;
        while (next != null) {
            listNodes.add(next);
            next = next.next;
        }

        next = headB;

        while (next != null) {
            if (listNodes.contains(next)) {
                return next;
            }

            next = next.next;
        }

        // 满足的条件是: headA.next==headB.next
        return null;
    }

    private static ListNode getIntersectionNodeByCursor(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode nextA = headA;
        ListNode nextB = headB;

        while (nextA != nextB) {
            nextA = nextA == null ? headB : nextA.next;
            nextB = nextB == null ? headA : nextB.next;
        }

        return nextA;
    }
}
