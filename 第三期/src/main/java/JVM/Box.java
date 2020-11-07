package main.java.JVM;

/**
 * 装箱拆箱字节码分析
 *
 * @author macfmc
 * @date 2020/8/22-14:27
 */
public class Box {
    public Integer cal() {
        Integer a = 1000;
        int b = a * 10;
        Integer.valueOf(10);
        return b;
    }

    static class BoxCache {
        public static void main(String[] args) {
            Integer n1 = 123;
            Integer n2 = 123;
            Integer n3 = 128;
            Integer n4 = 128;
            System.out.println(n1 == n2);
            System.out.println(n3 == n4);
        }
    }

    public class ArrayDemo {
        int getValue() {
            int[] arr = new int[]{111, 222, 333, 444};
            return arr[2];
        }

        int getLength(int[] arr) {
            return arr.length;
        }
    }
}
