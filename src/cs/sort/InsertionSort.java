package cs.sort;

/**
 * 类说明：简单插入排序（升序）
 */
public class InsertionSort {
    public static int[] sort(int[] array) {
        if (array.length == 0)
            return array;
        int currentValue;/*当前待排序数据，该元素之前的元素均已被排序过*/
        for (int i = 0; i < array.length - 1; i++) {
            int preIndex = i;/*已被排序数据的索引*/
            currentValue = array[preIndex + 1];
            System.out.println("待排序元素索引:" + (i + 1) + "，值为：" + currentValue +
                    ",已被排序数据的索引:" + preIndex);

            /*在已被排序过数据中倒序寻找合适的位置，如果当前待排序数据比比较的元素要小，
            将比较的元素元素后移一位*/
            while (preIndex >= 0 && currentValue < array[preIndex]) {
                //将当前元素后移一位
                array[preIndex + 1] = array[preIndex];
                preIndex--;
                PrintArray.print(array);
            }
            /*while循环结束时，说明已经找到了当前待排序数据的合适位置，插入*/
            array[preIndex + 1] = currentValue;
            System.out.println("本轮被插入排序后的数组");
            PrintArray.print(array);
            System.out.println("--------------------");
        }
        return array;
    }

    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = InsertionSort.sort(PrintArray.SRC);
        PrintArray.print(dest);
    }
}
