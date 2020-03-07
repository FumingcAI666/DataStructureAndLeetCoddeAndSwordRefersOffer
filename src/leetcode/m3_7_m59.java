package leetcode;

/**
 * @author macfmc
 * @date 2020/3/7-12:06
 */
public class m3_7_m59 {
    public static void main(String[] args) {

    }
    /**
     请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。

     若队列为空，pop_front 和 max_value 需要返回 -1

     示例 1：

     输入:
     ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
     [[],[1],[2],[],[],[]]
     输出: [null,null,null,2,1,2]
     示例 2：

     输入:
     ["MaxQueue","pop_front","max_value"]
     [[],[],[]]
     输出: [null,-1,-1]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class MaxQueue {
        int[] queue = new int[20000];
        int begin = 0, end = 0;

        public MaxQueue() { // []
        } //null

        public int max_value() { // [] []
            if (begin == end)
                return -1;
            int max = -1;
            for (int i = begin; i < end; ++i) { //
                if (queue[i] >= max)
                    max = queue[i];
            }
            return max;
        } //2 2

        public void push_back(int value) { //[1] [2]   做插入点 比如插入1 2 3 那么max只需要对比三个数就可以了
            queue[end++] = value;
        } //null null

        public int pop_front() { //[]
            // 收尾相等于0为null
            if (begin == end)
                return -1;
            return queue[begin++];
        } // 1
    }
}
