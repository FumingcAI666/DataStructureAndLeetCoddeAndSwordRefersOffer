package leetcode.offer;

/**
 * @author macfmc
 * @date 2020/6/15-20:43
 */
public class 面试题24_反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode cur = head;
        while (head.next != null) {
            ListNode temp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = temp;
        }
        return pre;

    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }
}
