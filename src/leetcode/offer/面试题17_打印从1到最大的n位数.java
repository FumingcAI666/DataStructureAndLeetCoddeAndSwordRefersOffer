package leetcode.offer;

/**
 * @author macfmc
 * @date 2020/6/12-22:32
 */
public class 面试题17_打印从1到最大的n位数 {

    /**
     * 逆序计算方便进位，存储时翻转一下
     * todo 没看懂，明天再说
     */
    StringBuilder sb;
    int idx = 0;

    /**
     * 累加的解法-涉及大数打印为题，这个解法不完善
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        // pow(a1, a2)为一个a1数的a2次方，10^n - 1
        int end = (int) Math.pow(10, n) - 1;

        int[] nums = new int[end];

        // 从1加到end，并存放在数组内
        for (int i = 0; i < end; i++)
            nums[i] = i + 1;

        return nums;
    }

    public boolean increment(int n) {
        boolean carry = false;
        for (int i = 0; i < sb.length(); ++i) {
            if (carry || i == 0) {
                if (sb.charAt(i) == '9') {
                    sb.setCharAt(i, '0');
                    carry = true;
                } else {
                    sb.setCharAt(i, (char) (sb.charAt(i) + 1));
                    carry = false;
                }
            } else {
                break; // no addition on last idx, no need to compute any more
            }
        }
        if (carry) {
            sb.append("1");
        }
        return sb.length() <= n; // overflow!
    }

    public void save(int ans[]) {
        ans[idx] = Integer.parseInt(sb.reverse().toString());
        sb.reverse();
    }

    public int[] printNumbers1(int n) {
        int[] ans = new int[(int) Math.pow(10, n) - 1];
        sb = new StringBuilder("0");
        while (increment(n)) {
            save(ans);
            idx++;
        }
        return ans;
    }


}
