package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**给定一个整数数组nums和一个目标值target,请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *示例:
 *给定 nums = [2, 7, 11, 15], target = 9
 *因为 nums[0] + nums[1] = 2 + 7 = 9
 *所以返回 [0, 1]
 *来源：力扣（LeetCode）
 *链接：https://leetcode-cn.com/problems/two-sum
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * *
 *  * @author jackLinkai
 *  * @date 2020年4月29日22点33分
 */
public class Solution1 {
    /**思路：
     * 首先建立一个hashMap，将数据存入 key为补数 ，value为下标
     *然后指针往下一位移动，用 containsKey(key) 方法来检查 key 是否存在，如果存在，
     * 则说明这个数为补数，添加
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        // 建立k-v，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
            //用 containsKey(key) 方法来检查 key 是否存在，如果存在，将该key（即补数）的值（即对应的数组下标）存放进数组indexs，同时存放该数的下标放进indexs，得到结果
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
        }
        return indexs;
    }

    public static void main(String[] args) {
        int []a={2,7,11,15};int ta=9;
        int []b={2,5,5,11};int tb=10;
        int []c={5,7,4,2,3,8};int tc=5;
        System.out.println(Arrays.toString(twoSum(a,ta)));
        System.out.println(Arrays.toString(twoSum(b,tb)));
        System.out.println(Arrays.toString(twoSum(c,tc)));
    }
}
