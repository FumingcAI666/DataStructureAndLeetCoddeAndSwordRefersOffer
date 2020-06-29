package leetcode.offer;

import java.util.Stack;

/**
 * @author macfmc
 * @date 2020/6/15-20:25
 */
public class 面试题06_从尾到头打印链表 {
    /**
     * Stack是后进先出表
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack stack = new Stack();
        ListNode temp = head;
        // 遍历链表 -> 保存在栈中
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // 去除元素 -> 保存在出参中
        int[] a = new int[stack.size()];
        for (int i = 0; i < a.length; i++) {
            ListNode listNode = (ListNode) stack.pop();
            a[i] = listNode.val;
        }
        return new int[10];
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }
}
