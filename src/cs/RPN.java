package cs;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author macfmc
 * @date 2020/6/8-14:15
 */
public class RPN {
    public static void main(String[] args) {

    }

    class ArrStack {
        // 定义数组保存元素
        private Object[] elementData;
        // 定义栈的当前长度
        private int size;
        // 定义栈的当前容量
        private int capacity;
        //
        private int top;

        // 初试化，建立一个容量为50的数组
        public ArrStack() {
            elementData = new Object[50];
            capacity = 50;
        }

        // 入栈
        public <T> void push(T data) {
            // 如果容器满了，则新建一个数组扩容
            if (size >= capacity) {
                int newLength = (capacity * 3 / 2) + 1;
                elementData = Arrays.copyOf(this.elementData, newLength);
                capacity = newLength;
            }
            elementData[top] = data;
            top++;
            size++;
        }

        // 出栈
        public <T> T pop() {
            if (size == 0) // 当前为空栈
                return null;
            else {
                T data = (T) this.elementData[top - 1];
                top--;
                size--;
                return data;
            }
        }

        // 遍历栈

    }
}
