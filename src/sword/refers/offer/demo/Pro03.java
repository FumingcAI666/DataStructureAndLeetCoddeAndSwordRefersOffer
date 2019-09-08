package sword.refers.offer.demo;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 *
 * @author macfmc
 * @date 2019/8/26-17:40
 */
public class Pro03 {
    public static void main(String[] args) {
        ListNode03 listNode03 = new ListNode03(9);
        System.out.println(printListFromTailToHead(listNode03));
    }

    /**
     * 倒叙遍历链表
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode03 listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (listNode != null) {
            // 头插法
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    static class ListNode03 {
        int val;
        ListNode03 next = null;

        ListNode03(int val) {
            this.val = val;
        }
    }

}

