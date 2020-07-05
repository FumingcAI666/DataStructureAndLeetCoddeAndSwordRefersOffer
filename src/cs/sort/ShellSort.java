package cs.sort;

/**
 * 类说明：希尔排序
 */
public class ShellSort {
    public static int[] sort(int[] array) {
        int len = array.length;
        /*按增量分组后，每个分组中，temp代表当前待排序数据，该元素之前的元素均已被排序过*/
        /*gap指用来分组的增量，会依次递减*/
        int currentValue, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                currentValue = array[i];
                /*组内已被排序数据的索引*/
                int preIndex = i - gap;
                /*在组内已被排序过数据中倒序寻找合适的位置，如果当前待排序数据比比较的元素要小，
                并将比较的元素元素在组内后移一位*/
                while (preIndex >= 0 && array[preIndex] > currentValue) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                /*while循环结束时，说明已经找到了当前待排序数据的合适位置，插入*/
                array[preIndex + gap] = currentValue;
            }
            System.out.println("本轮增量【" + gap + "】排序后的数组");
            PrintArray.print(array);
            System.out.println("--------------------");
            gap /= 2;
        }
        return array;
    }

    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = ShellSort.sort(PrintArray.SRC);
        PrintArray.print(dest);
    }
}
