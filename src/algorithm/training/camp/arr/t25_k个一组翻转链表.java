package algorithm.training.camp.arr;

/**
 * @author macfmc
 * @date 2020/11/12-9:07
 */
public class t25_k个一组翻转链表 {

    /**
     * 时间复杂度O(n)，空间复杂度O(1) 假设；head=[1,2,3,4,5] ,k=2
     *
     * @param head 链表实例头结点
     * @param k    翻转的K数
     * @return
     */
    public ListNode reverseKGroup0(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 创建一个空节点[0]
        ListNode dummy = new ListNode(0);
        // 将新创建的空结点 指向head节点[0 -> 1,2,3,4,5],此时dummy=[0,1,2,3,4,5]
        dummy.next = head;

        // 设置两个记录指针，此时pre=[0,1,2,3,4,5],此时end=[0,1,2,3,4,5]
        ListNode pre = dummy;
        ListNode end = dummy;

        // 遍历链表
        while (end.next != null) {
            // 这里设计的很巧妙，遍历k次的end，使end最终等于需要交换的节点,此时end=[2,3,4,5]
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // end如果为null，就跳出链表的遍历，证明已经把所有需要的节点交换完毕
            if (end == null) {
                break;
            }


            // 这是创建两个交换指针 ，start=[1,2,3,4,5] next=[3,4,5]
            // 记录要翻转链表的头节点
            ListNode start = pre.next;
            // 记录下end.next,方便后面链接链表
            ListNode next = end.next;
            // 将end下一个指向null，目的是断开链表，end=[2,null ...]同时start=[1,2,null ...] ,就是end=[2],start=[1,2],
            end.next = null;

            // 拿到start需要反转的链表开始反转，此时执行完反转方法 pre=[0,2,1],dummy=[0,2,1],head=[1],start=[1],end=[2,1] , next=[3,4,5]
            pre.next = reverse(start);

            // 翻转后头节点变到最后。通过.next把断开的链表重新链接。start=[1,3,4,5],此时pre=[0,2,1,3,4,5],dummy=[0,2,1,3,4,5],end=[2,1,3,4,5] , next=[3,4,5]
            start.next = next;

            // 将pre换成下次要翻转的链表的头结点的上一个节点。即start pre=[1,3,4,5]
            pre = start;

            // 翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start end=[1,3,4,5] , 其余同理（遍历第二遍dummy=[0,2,1,4,3,5],pre=[3,5]end=[3,5]）
            end = pre;
        }
        // 返回链表头结点
        return dummy.next;
    }

    /**
     * 反转链表，此时的head是需要反转的链表
     */
    private ListNode reverse(ListNode head) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null) {
            return head;
        }

        // 创造当前节点的前一个节点
        ListNode pre = null;
        // 当前节点指针,此时curr就是[1,2]
        ListNode curr = head;

        // 遍历当前节点的链表
        while (curr != null) {
            // 记录指向下一个节点,保存当前节点后面的链表，next=[2] ; 第二次循环next=null
            ListNode next = curr.next;
            // 将curr当前节点next域指向前一个节点pre，此时curr=[1],pre=null,head=[1] ; 第二次循环next=null，curr=[2，1]
            curr.next = pre;
            // pre指针向后移动，此时pre只想当前节点 pre=[1] ; 第二次循环pre=[2,1]
            pre = curr;
            // cur指针向后移动。下一个节点变成当前节点 curr=[2],pre=[1],head=[1] ; 第二次循环curr = null,pre=[2,1],head=[1]
            curr = next;
        }
        // 返回已交换链表的头结点
        return pre;
    }

    /**
     * 递归，时间复杂度O(n)，空间复杂度O(n)
     *
     * @param head 链表实例头结点
     * @param k    翻转的K数
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 设置递归尾巴
        ListNode tail = head;

        // 找到待翻转的k个节点
        for (int i = 0; i < k; i++) {
            //剩余数量小于k的话，则不需要反转。
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        // 反转前 k 个元素,将上一轮翻转后的尾结点指向下一轮翻转后的头节点，即将每一轮翻转的k的节点连接起来。
        ListNode newHead = reverse(head, tail);

        // 下一轮的开始的地方就是tail,对下一轮 k 个节点也进行翻转操作。
        head.next = reverseKGroup(tail, k);

        // 返回
        return newHead;
    }

    /**
     * @param head 整个未反转的链表
     * @param tail 本轮不需要反转的链表
     * @return
     */
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;

        // 对其进行翻转。并返回翻转后的头结点
        while (head != tail) {
            // 每次都将当前节点的指针反转

            // 报错为反转的节点
            next = head.next;

            // 待反转的节点指向pre（pre会向后移动的）
            head.next = pre;
            // pre重新指向当前头结点
            pre = head;

            // head向后移动到未反转的节点
            head = next;
        }
        return pre;
    }

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

