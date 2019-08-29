package sword.refers.offer.demo;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author macfmc
 * @date 2019/8/30-0:27
 */
public class Pro14 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        System.out.println(FindKthToTail(listNode, 2));
    }

    /**
     * 查询该链表中倒数第k个结点
     *
     * @param head 链表
     * @param k
     * @return 该链表中倒数第k个结点
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode pre = null, p = null;
        //两个指针都指向头结点
        p = head;
        pre = head;
        //记录k值
        int a = k;
        //记录节点的个数
        int count = 0;
        //p指针先跑，并且记录节点数，当p指针跑了k-1个节点后，pre指针开始跑，
        //当p指针跑到最后时，pre所指指针就是倒数第k个节点
        while (p != null) {
            p = p.next;
            count++;
            if (k < 1) {
                pre = pre.next;
            }
            k--;
        }
        //如果节点个数小于所求的倒数第k个节点，则返回空
        if (count < a) {
            return null;
        }
        return pre;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("ListNode{");
            sb.append("val=").append(val);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }

}

