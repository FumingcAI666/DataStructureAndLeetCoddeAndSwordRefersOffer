package algorithm.training.camp.arr;

import java.util.HashSet;
import java.util.Set;

/**
 * @author macfmc
 * @date 2020/11/7-11:45
 */
public class t141_环形链表 {
    /**
     * 哈希表，时间复杂度O(n),空间复杂度O(n)
     */
    public boolean hasCycle0(ListNode head) {
        if (head == null || head.next != null) {
            return false;
        }
        // 创建Hash表（无序不可重复的特点）
        Set<ListNode> seen = new HashSet<ListNode>();
        // 如果不为空，证明还没循环完
        while (head != null) {
            // 有重复的
            if (!seen.add(head)) {
                return true;
            }
            // 遍历下一个节点
            head = head.next;
        }
        // 全部放一遍没有重复的
        return false;
    }

    /**
     * 快慢指针，时间复杂度O(n),空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // 头结点不为null，或者头结点的下一个节点不为null，防止只有一个节点，后续报空指针
        if (head == null || head.next == null) {
            return false;
        }
        // 设置快慢指针
        ListNode i = head;
        // 从头结点的下一位开始，一前一后遍历链表
        ListNode j = i.next;
        // 如果j追赶上i
        while (i != j) {
            // 只有一位j就是空的，或者j的后面没有元素了，返回false
            if (j == null || j.next == null) {
                return false;
            }
            // i指针走一步
            i = i.next;
            // j指针走两步
            j = j.next.next;
        }
        // i=j的情况，证明具有环形链表
        return true;
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
