package algorithm.training.camp.arr;

/**
 * @author macfmc
 * @date 2020/11/10-9:14
 */
public class t24_两两交换链表中的节点 {
    /**
     * 递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
     * 如果链表中至少有两个节点，则在两两交换链表中的节点之后，原始链表的头节点变成新的链表的第二个节点， 原始链表的第二个节点变成新的链表的头节点。
     * 链表中的其余节点的两两交换可以递归地实现。
     * 在对链表中的其余节点递归地两两交换之后， 更新节点之间的指针关系，即可完成整个链表的两两交换。
     * <p>
     * 用 head 表示原始链表的头节点，新的链表的第二个节点,
     * 用 newHead 表示新的链表的头节点，原始链表的第二个节点，
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 则原始链表中的其余节点的头节点是 newHead.next
        ListNode newhead = head.next;

        // 令 head.next = swapPairs(newHead.next)，表示将其余节点进行两两交换,
        head.next = swapPairs1(newhead.next);

        // 交换后的新的头节点为 head 的下一个节点,然后令 newHead.next = head，即完成了所有节点的交换。
        newhead.next = head;

        // 最后返回新的链表的头节点 newHead
        return newhead;
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;


        ListNode temp = dummyHead;


        while (temp.next != null && temp.next.next != null) {

            ListNode node1 = temp.next;

            ListNode node2 = temp.next.next;

            temp.next = node2;

            node1.next = node2.next;

            node2.next = node1;

            temp = node1;
        }


        // 最后返回新的链表的头节点dummyHead的下一个节点 head
        return dummyHead.next;
    }


    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
