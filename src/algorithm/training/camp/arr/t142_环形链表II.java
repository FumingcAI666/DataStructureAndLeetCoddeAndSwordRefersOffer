package algorithm.training.camp.arr;

import java.util.HashSet;
import java.util.Set;

/**
 * @author macfmc
 * @date 2020/11/11-19:54
 */
public class t142_环形链表II {
    public ListNode detectCycle0(ListNode head) {
        // 如果链表是null，或者只有一个就没有环，直接返回null
        if (head == null || head.next == null) {
            return null;
        }

        // 设置慢节点
        ListNode i = head;
        // 设置快节点
        ListNode j = head;

        // 循环遍历找重合点
        while (true) {
            // 如果快指针遍历结束，证明没有环
            if (j.next == null || j.next.next == null) {
                return null;
            }
            // 慢指针一次移动一位
            i = i.next;
            // 快指针一次移动两位
            j = j.next.next;
            // 如果快慢指针重合，证明有环
            if (i == j) {
                break;
            }
        }

        // 将慢指针重新指向头结点
        i = head;

        // j指针 位置不变 ，将i指针重新 指向链表头部节点 ；i和j同时每轮向前走n步； 此时f=0,s=nb；
        // 当i指针走到f=a步时，j指针走到步s=a+nb，此时 两指针重合，并同时指向链表环入口 。

        // 重新循环，返回索引为 1 (pos = 1)的链表节点(链表环入口)
        while (i != j) {
            i = i.next;
            j = j.next;
        }
        return i;
    }


    public ListNode detectCycle(ListNode head) {
        // 如果链表是null，或者只有一个就没有环，直接返回null
        if (head == null || head.next == null) {
            return null;
        }

        // 创建一个空的Hash表
        Set set = new HashSet<ListNode>();
        ListNode i = head;

        // 从头节点开始遍历
        while (i != null) {
            // set中如果存在就直接返回
            if (set.contains(i)) {
                return i;
            } else {
                // 如果不存在，则add到hash表中
                set.add(i);
            }
            i = i.next;
        }
        // 循环结束
        return null;
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
