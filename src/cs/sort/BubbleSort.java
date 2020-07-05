package cs.sort;

/**
 * 类说明：冒泡算法（升序）
 */
public class BubbleSort {
    public static int[] sort(int[] array) {
        if (array.length == 0)
            return array;
        /*循环数组长度的次数*/
        for (int i = 0; i < array.length; i++) {

            /*从第0个元素开始，依次和后面的元素进行比较
             * j < array.length - 1 - i表示第[array.length - 1 - i]
             * 个元素已经冒泡到了合适的位置，无需进行比较，可以减少比较次数*/
            for (int j = 0; j < array.length - 1 - i; j++) {
                /*如果第j个元素比后面的第j+1元素大，交换两者的位置*/
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
                //PrintArray.print(array);
            }
//            System.out.println("---------------");
//            PrintArray.print(array);
        }

        return array;
    }

    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = BubbleSort.sort(PrintArray.SRC);
        PrintArray.print(dest);
    }
}
