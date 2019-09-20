package sword.refers.offer.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 * 题目描述：
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * @author macfmc
 * @date 2019/9/20-10:41
 */
public class Pro29 {
    public static void main(String[] args) {
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution2(a, 4));
        System.out.println(GetLeastNumbers_Solution1(a, 4));
    }

    /**
     * 可以选择使用快排的Partition函数，简单划分，但是并不排序，较为快速的解决问题。
     *
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (k <= 0) {
            return result;
        }
        if (input.length == 0 || input.length < k) {
            return result;
        }
        int start = 0;
        int end = input.length - 1;
        int index = Partition(input, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = Partition(input, start, end);
            } else {
                start = index + 1;
                index = Partition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public static int Partition(int[] input, int start, int end) {
        int pivot = input[start];
        while (start < end) {
            while (start < end && input[end] >= pivot) {
                --end;
            }
            input[start] = input[end];
            while (start < end && input[start] <= pivot) {
                ++start;
            }
            input[end] = input[start];
        }
        input[end] = pivot;
        return end;
    }


    /**
     * 最大堆，用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
     *
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if (k > length || k == 0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}
