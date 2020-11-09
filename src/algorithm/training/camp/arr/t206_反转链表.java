package algorithm.training.camp.arr;

/**
 * @author macfmc
 * @date 2020/11/9-19:39
 */
public class t206_反转链表 {
    /**
     * 迭代法，时间复杂度O(n)
     *
     * @param head
     * @return
     */
    public ListNode reverseList0(ListNode head) {
        // 对链表进行判空，空或者只有一个直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 创建一个新联表的头结点
        ListNode newListNode = null;
        // 遍历老的链表，比如 1 -> 2 -> 3 -> null
        while (head != null) {
            // 将每个数都保存,保存 2
            ListNode nextTemp = head.next;

            // 因为newListNode是空，所以老链表：null <- 1 -> 2 ->3
            head.next = newListNode;

            // 将pre右移一位，和老链表头重合
            newListNode = head;

            // 将头右移一位，进行下一次循环
            head = nextTemp;
            // 老链表null <- 1 <- 2 -> 3,新newListNode=2,
            // 老链表:null <- 1 <- 2 <- 3 ,新newListNode=3
        }
        return newListNode;
    }

    /**
     * 递归法，时间复杂度O(n)
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 对链表进行判空，空或者只有一个直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 创建一个新联表的头结点,递归向右移动，一直找到最后一个数，此时head=5，newListNode=5且不变
        ListNode newListNode = reverseList(head.next);

        // 将最后两位交换指向
        // 4.next.next = 4 即5.next=4
        head.next.next = head;
        // 断开老的链路
        head.next = null;

        // 4.next=3,3.next=null
        // 3.next=2,2.next=null ...

        return newListNode;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }
}
