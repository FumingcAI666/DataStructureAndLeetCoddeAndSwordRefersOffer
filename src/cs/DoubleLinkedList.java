package cs;

/**
 * 带哨兵的双向链表
 *
 * @author macfmc
 * @date 2020/5/1-19:19
 */
public class DoubleLinkedList {
    private Node nil; // 哨兵节点

    public DoubleLinkedList() {
        nil = new Node(null); // NIL节点的key值没有实际的意义
        nil.pre = nil;  // NIL.next指向自己
        nil.next = nil; // NIL.pre也指向自己
    }

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.insert(Integer.valueOf(1));
        System.out.println(dll.search(Integer.valueOf(1)).key);
        dll.delete(Integer.valueOf(1));
    }

    // 当添加了若干个节点之后，NIL.next指向头节点，而NIL.pre则指向尾节点；
    // 而同样的，这时头节点的pre不再是NULL而是指向NIL，尾节点的next也不再是NULL，也是指向NIL。
    public void insert(Object o) {
        Node e = new Node(o);
        e.next = nil.next; // ① 如果是第一次插入，nil的next指向第一个节点，如果是n(n>1)次，新e的后继指向前一个插入节点(老e)
        nil.next.pre = e;  // ② 如果是第一次插入，nil的pre指向头结点，如果是n(n>1)次，老e的前驱指向新e
        nil.next = e; // ③ nil节点next 指向新插入的节点（尾结点）
        e.pre = nil; // ④ 新插入的节点的前驱指向 哨兵节点
    }

    public Node search(Object o) {
        Node e = nil.next;
        while (e != nil && e.key != o) {
            e = nil.next;
        }
        return e;
    }

    public void delete(Object o) {
        Node e = search(o);
        e.pre.next = e.next;
        e.next.pre = e.pre;
    }

    public class Node {
        public Object key;
        private Node pre;
        private Node next;

        public Node(Object x) {
            this.key = x;
        }
    }

}
