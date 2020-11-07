package cs;

import java.util.ArrayDeque;

/**
 * 循环队列
 * <p>
 * 注意：判空和判满的两种情况：
 * 情况1.另设一个标识位区别队列是空还是满
 * 情况2.少用一个元素空间，约定以"队列头指针在队尾指针的下一位位置上" 作为队列满的标志
 *
 * @author macfmc
 * @date 2020/6/4-11:56
 */
public class CycQueue<T> {
    int[] queue = null;
    int front = 0;
    int rear = 0;
    boolean empty = true; //true表示循环队列为空

    // 构造指定大小的循环队列
    CycQueue(int max) {
        this.queue = new int[max];
    }

    public static void main(String[] args) {
        CycQueue<Integer> cycQueue = new CycQueue<>(6);

        cycQueue.enQueue(1);
        cycQueue.enQueue(2);
        cycQueue.enQueue(3);
        cycQueue.enQueue(4);
        cycQueue.enQueue(5);
        cycQueue.enQueue(6);

        Integer s = cycQueue.queueLength();
        System.out.println(cycQueue.getHead());
        for (Integer integer = 0; integer < s; integer++) {
            System.out.println(cycQueue.deQueue());
        }
        System.out.println(cycQueue.queueEmpty());

        cycQueue.enQueue(4);
        cycQueue.enQueue(5);
        cycQueue.enQueue(6);
        s = cycQueue.queueLength();
        for (Integer integer = 0; integer < s; integer++) {
            System.out.println(cycQueue.deQueue());
        }
        System.out.println(cycQueue.queueEmpty());
    }

    // 清空循环队列
    public void clearQueue() {
        this.front = 0;
        this.rear = 0;
        this.empty = true;

    }

    // 检测循环队列是否为空
    public boolean queueEmpty() {
        if (this.empty == true) {
            return true;
        } else {
            return false;
        }
    }

    // 返回循环队列的元素个数
    public int queueLength() {
        if (this.front == this.rear && this.empty == false) {
            return this.queue.length;  //如果循环队列已满，返回数组长度即元素个数
        }
        return (this.rear - this.front + this.queue.length) % this.queue.length;   //否则，取模运算得到长度
    }

    // 向队尾插入元素
    public boolean enQueue(int value) {
        if (this.empty == false && this.front == this.rear) {
            return false;
        }

        this.queue[this.rear] = value;
        this.rear = (this.rear + 1) % this.queue.length;
        this.empty = false;
        return true;
    }

    // 返回对头
    private int[] getHead() {
        if (this.empty == true) {
            return null;
        }
        int[] i = new int[1];
        i[0] = this.queue[this.front];  //获取队头元素
        return i;

    }

    // 删除并返回队头元素
    public int[] deQueue() {

        if (this.empty == true) {
            return null;
        }

        int[] i = new int[1];
        i[0] = this.queue[this.front];  //获取队头元素

        this.front = (this.front + 1) % this.queue.length;  //删除队头元素（front指针加一）

        if (this.front == this.rear) {   //如果循环队列变空，改变标志位
            this.empty = true;
        }
        return i;
    }

    // 遍历循环队列
    public String queueTraverse() {   //此处用输出循环队列表示遍历
        String s = "";
        int i = this.front;   //i指向第一个元素

        if (this.front == this.rear && this.empty == false) {   //如果循环队列已满，取出第一个元素，i指向下一个元素
            s += this.queue[i] + "、";
            i = (i + 1) % this.queue.length;
        }

        while (i != this.rear) {   //如果未到末尾，则循环读取元素
            s += this.queue[i] + "、";
            i = (i + 1) % this.queue.length;
        }

        if (s.length() == 0) {   //如果没有读取到元素，直接返回空字符串
            return s;
        }
        return s.substring(0, s.length() - 1);   //除去最后的顿号返回
    }


}
