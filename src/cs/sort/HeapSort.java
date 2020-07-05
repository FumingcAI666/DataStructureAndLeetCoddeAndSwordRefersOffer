package cs.sort;

/**
 * 类说明：堆排序
 */
public class HeapSort {
    //声明全局变量，用于记录数组array的长度；
    private static int len;

    public static int[] sort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
            PrintArray.print(array);
            System.out.println("--------------------");
        }
        return array;
    }

    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len / 2 - 1); i >= 0; i--) {
            adjustHeap(array, i);
        }
        System.out.println("构造完成最大堆");
        PrintArray.print(array);
        System.out.println("============================================");
    }

    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        int left = 2 * i + 1;
        int right = 2 * (i + 1);
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (left < len && array[left] > array[maxIndex])
            maxIndex = left;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (right < len && array[right] > array[maxIndex])
            maxIndex = right;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = HeapSort.sort(PrintArray.SRC);
        PrintArray.print(dest);
    }
}
