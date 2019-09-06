package sword.refers.offer.demo;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * @author macfmc
 * @date 2019/9/6-0:05
 */
public class Pro19 {
    /**
     * 保存数据
     */
    Stack<Integer> data = new Stack<>();
    /**
     * 保存最小值
     */
    Stack<Integer> min = new Stack<>();
    Integer temp = null;

    /**
     * 用一个栈data保存数据，用另一个栈min保存依次入栈的最小数(后来的数只有 比 以前入栈的数小，才会入栈)
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public void push(int node) {
        //表明min栈中的数据
        if (temp != null) {
            //存放数据
            data.push(node);
            if (node < temp) {
                //小的入栈
                min.push(node);
            }
        } else {
            //第一次添加数据
            data.push(node);
            temp = node;
            min.push(node);
        }
    }

    public void pop() {
        //data进行pop时，把min也pop出来
        int num1 = data.pop();
        int num2 = min.pop();
        //如果data出来的不是最小的，在把最小值push回min中
        if (num1 != num2) {
            min.push(num2);

        }
    }

    /**
     * 取出数据，但不删除
     *
     * @return
     */
    public int top() {
        //因此pop后，在push进去
        int num = data.pop();
        data.push(num);
        return num;
    }

    /**
     * 取出数据，但不删除
     *
     * @return
     */
    public int min() {
        //因此pop后，在push进去
        int m = min.pop();
        min.push(m);
        return m;
    }

}
