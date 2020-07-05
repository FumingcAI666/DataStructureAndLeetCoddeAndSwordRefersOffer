package cs.sort;

import java.util.Arrays;

/**
 * 类说明：CountingSort
 */
public class CountingSort {
    final static int[] src = {5, 4, 5, 0, 3, 6, 2, 0, 2, 4, 3, 3};

    public static int[] sort(int[] array) {
        if (array.length == 0) return array;
        /*寻找数组中最大值，最小值
         * bias:偏移量,用以定位原始数组每个元素在计数数组中的下标位置*/
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        /*获得计数数组的容量*/
        int[] counterArray = new int[max - min + 1];
        Arrays.fill(counterArray, 0);
        /*遍历整个原始数组，将原始数组中每个元素值转化为计数数组下标，
        并将计数数组下标对应的元素值大小进行累加*/
        for (int i = 0; i < array.length; i++) {
            counterArray[array[i] + bias]++;
        }
        System.out.println("计数数组为：");
        PrintArray.print(counterArray);
        System.out.println("============================================");
        int index = 0;/*访问原始数组时的下标计数器*/
        int i = 0;/*访问计数数组时的下标计数器*/
        /*访问计数数组，将计数数组中的元素转换后，重新写回原始数组*/
        while (index < array.length) {
            /*只要计数数组中当前下标元素的值不为0，就将计数数组中的元素转换后，重新写回原始数组*/
            if (counterArray[i] != 0) {
                array[index] = i - bias;
                counterArray[i]--;
                index++;
            } else
                i++;
            PrintArray.print(counterArray);
            PrintArray.print(array);
            System.out.println("--------------------");
        }
        return array;
    }

    public static void main(String[] args) {

        PrintArray.print(src);
        System.out.println("============================================");
        int[] dest = CountingSort.sort(src);
        PrintArray.print(dest);
    }
}
