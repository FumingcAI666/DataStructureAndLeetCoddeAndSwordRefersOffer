package sword.refers.offer.demo;

import java.util.StringJoiner;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @author macfmc
 * @date 2019/8/30-22:49
 */
public class Pro15 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(4);
        ListNode list2 = new ListNode(2);
        System.out.println(bocia(list1, list2).toString());
    }

    /**
     * 将节点2的值插入到节点1之后
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode bocia(ListNode list1, ListNode list2) {
        // 单链表为null的处理情况
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        /**
         * 单链表头结点的确定
         */
        // head初始指向值较小的节点
        ListNode head = list1.val <= list2.val ? list1 : list2;
        // cur1初始指向值较小的节点
        ListNode cur1 = head == list1 ? list1 : list2;
        // cur2初始指向值较大的节点
        ListNode cur2 = head == list1 ? list2 : list1;
        /**
         *  合并后链表的前置和后置指针
         */
        // pre指向上一次比较中节点值较小的节点
        ListNode pre = null;
        // next用于保存链表2中的下一个节点
        ListNode next = null;
        // 遍历链表，执行插入操作
        while (cur1 != null && cur2 != null) {
            // 节点1值较小，无需调整
            if (cur1.val <= cur2.val) {
                pre = cur1;
                cur1 = cur1.next;

                // 节点1值较大，将节点2插入节点1
            } else {
                // 保存链表2的下一节点
                next = cur2.next;

                // 插入节点cur2
                pre.next = cur2;
                cur2.next = cur1;

                // pre指向上一次比较中节点值较小的节点
                pre = cur2;

                // 恢复链表2指向
                cur2 = next;
            }
        }
        // 追加链表剩余部分
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                    .add("val=" + val)
                    .add("next=" + next)
                    .toString();
        }
    }
}
