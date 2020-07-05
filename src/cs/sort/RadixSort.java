package cs.sort;

import java.util.ArrayList;

/**
 * 类说明：基数排序
 */
public class RadixSort {
    public static int[] sort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        /*找出最大数*/
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }

        /*先算出最大数的位数*/
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        /*构建桶*/
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        /*按照从右往左的顺序，依次将每一位都当做一次关键字，然后按照该关键字对数组排序，
        每一轮排序都基于上轮排序后的结果*/
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            /*遍历原始数组，投入桶中*/
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            /*桶中的数据写回原始数组，清除桶，准备下一轮的排序*/
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }

    public static void main(String[] args) {
        PrintArray.print(PrintArray.SRC);
        System.out.println("============================================");
        int[] dest = RadixSort.sort(PrintArray.SRC);
        PrintArray.print(dest);
    }
}
