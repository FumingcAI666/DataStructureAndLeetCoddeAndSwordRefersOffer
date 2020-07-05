package cs.sort;

import java.util.ArrayList;

/**
 * 类说明：
 */
public class PrintArray {

    public final static int[] SRC
            = {86, 11, 77, 23, 32, 45, 58, 63, 93, 4, 37, 22};

    public static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println("");
    }

    public static void printIndex(int[] array, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println("");
    }

    public static void printObject(ArrayList<Integer> array) {
        for (int i : array) {
            System.out.print(i + "  ");
        }
        System.out.println("");
    }

    public static void printObjectIndex(ArrayList<Integer> array, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            System.out.print(array.get(i) + "  ");
        }
        System.out.println("");
    }
}
