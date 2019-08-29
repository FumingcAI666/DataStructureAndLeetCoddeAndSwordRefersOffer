package sword.refers.offer.demo;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 *
 * @author macfmc
 * @date 2019/8/29-13:34
 */
public class Pro12 {
    public static void main(String[] args) {
        System.out.println(Power(2, 3));
    }

    /**
     * 考察指数的正负、底数是否为零等情况
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        if (base == 0) {
            if (exponent == 0) {
                return 1;
            }
            return 0;
        }

        if (exponent == 0) {
            return 1;
        } else if (exponent < 0) {
            double res = 1;
            for (int i = 0; i < -exponent; i++) {
                res *= (1.0 / base);
            }
            return res;
        } else {
            double res = 1;
            for (int i = 0; i < exponent; i++) {
                res *= base;
            }
            return res;
        }
    }
}
