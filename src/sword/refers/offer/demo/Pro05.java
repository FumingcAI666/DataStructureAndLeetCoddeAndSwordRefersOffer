package sword.refers.offer.demo;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author macfmc
 * @date 2019/8/26-18:00
 */
public class Pro05 {
    /**
     * Stack特性：先进后出
     */
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        Pro05 pro05 = new Pro05();
        pro05.push(1);
        pro05.push(2);
        pro05.push(3);
        pro05.pop();
        System.out.println(pro05.toString());
        pro05.push(1);
        pro05.push(4);
        System.out.println(pro05.toString());

    }

    /**
     * 栈1保存数据
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 在pop前，先将stack1中中的数据清空放入stack2（保存后入的在栈底），stack1始终用于push
     *
     * @return
     */
    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pro05{");
        sb.append("stack1=").append(stack1);
        sb.append(", stack2=").append(stack2);
        sb.append('}');
        return sb.toString();
    }
}
