package algorithm.training.camp.arr;

/**
 * @author macfmc
 * @date 2020/11/14-14:00
 */
public class t21_合并两个有序链表 {

    /**
     * 合并两个有序链表，暴力法：O(m+n)，空间复杂度O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists0(ListNode l1, ListNode l2) {
        // 创建一个空节点
        ListNode listNode = new ListNode(-1);
        // 创建一个连接指针
        ListNode pre = listNode;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                // 如果l1小于等于l2，l1向后一位，pre指向l1
                pre.next = l1;
                l1 = l1.next;
            } else {
                // 如果l1大于l2，l2向后一位，pre指向l2
                pre.next = l2;
                l2 = l2.next;
            }
            // pre向后移动一位
            pre = pre.next;
        }

        // 处理剩余链表，合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        pre.next = l1 == null ? l2 : l1;
        // 返回空节点的下一个节点，即链表的头结点
        return listNode.next;
    }


    /**
     * 递归法：O(m+n)，空间复杂度O(m+n)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 如果两个链表有一个为空，递归结束。
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 判断 l1 和 l2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
