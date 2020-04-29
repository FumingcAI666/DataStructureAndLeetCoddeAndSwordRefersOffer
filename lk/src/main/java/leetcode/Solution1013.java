package leetcode;

/**将数组分成和相等的三个部分
 * 给你一个整数数组A
 * 只有可以将其划分为三个和相等的非空部分时才返回true
 * 否则返回 false
 * 形式上，如果可以找出索引i+1<j
 * 且满足(A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 * 就可以将数组三等分
 *示例 1：
 * 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * 提示：
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 *
 *  来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jackLinkai
 * @date 2020年4月29日21点55分
 */

public class Solution1013 {

     /** 思路：
     * 1.先判断数组是否符合要求：* 3 <= A.length <= 50000 * -10^4 <= A[i] <= 10^4
     * 2.然后求该数组值的总和sum，是否为3的倍数，不是的话不符合条件，是的话得到sum/=3。
     * 3.最后，从头开始遍历并求和，通过group+=A[i]，判断group==sum,依次获取第一组、第二组，并校验比三组。
     */

    public static boolean canThreePartsEqualSum(int[] A) {
        //获取数组长度
        int len=A.length;
        //如果长度小于3或大于50000，则不符合题干要求
        if(len<3||len>50000) {
            return false;
        }
        //使用增强for循环得出该数组总和
        int sum=0;
        for (int num: A) {
            if(num<-1000||num>10000){
                return false;
            }
            sum += num;
        }
        //如果总和不是3的倍数，说明不能分为3组值相同的数组
        if(sum%3!=0) {
            return false;
        }
        //假设可以分为三组值相同的子数组，求此子数组和为sum/=3
        sum/=3;
        //group为统计子数组的和，index为统计子数组个数，当group==sum时，说明此为一个子数组，当子数组个数为2个时，即可跳出循环
        //遍历该数组，特别的，只遍历前len-1个数字，防止分完的3个数组出现空的子数组
        int group=0,index=0;
        for (int i=0;i<len-1;i++){
            group+=A[i];
            if(group==sum){
                index++;
                group=0;
            }
            //结合上述，当获取出2个子数组后，说明改数组符合题干要求，返回true
            if(index==2){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int []a={0,2,1,-6,6,-7,9,1,2,0,1};
        int []b={0,2,1,-6,6,7,9,-1,2,0,1};
        int []c={3,3,6,5,-2,2,5,1,-9,4};
        System.out.println("a:"+canThreePartsEqualSum(a));
        System.out.println("b:"+canThreePartsEqualSum(b));
        System.out.println("c:"+canThreePartsEqualSum(c));
    }
}
