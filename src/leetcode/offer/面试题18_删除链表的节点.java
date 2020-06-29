package leetcode.offer;

/**
 * @author macfmc
 * @date 2020/6/15-19:33
 */
public class 面试题18_删除链表的节点 {
    /**
     * 遍历->保存->删除
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val)
            return head.next;

        ListNode cur = head;
        // 此时cur是val节点
        while (cur.next != null && cur.next.val != val)
            cur = cur.next;

        // 删点cur节点
        if (cur.next != null)
            cur.next = cur.next.next;
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }
}
