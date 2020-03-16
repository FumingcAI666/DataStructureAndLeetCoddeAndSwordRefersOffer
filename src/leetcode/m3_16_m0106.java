package leetcode;

/**
 * @author macfmc
 * @date 2020/3/16-14:09
 */
public class m3_16_m0106 {

    public static void main(String[] args) {
        System.out.println(compressString("bbbac"));
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("abbccd"));
        System.out.println(compressString("a"));
        System.out.println(compressString("IIIIeeeeOODDDssppppooQQQQppplllhU")); // "I4e4O2D3s2p4o2Q4p3l3h1U1"

    }

    /**
     字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
     比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。

     示例1:
     输入："aabcccccaaa"
     输出："a2b1c5a3"
     示例2:
     输入："abbccd"
     输出："abbccd"
     解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     提示：

     字符串长度在[0, 50000]范围内。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/compress-string-lcci
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static String compressString(String s) {
        if (s.length() == 1 || s == null || s == "") {
            return s;
        }
        char[] sc = s.toCharArray();
        int num = 1;
        StringBuffer strb = new StringBuffer();

        for (int i = 0; i < sc.length - 1; i++) {
            if (sc[i] == sc[i + 1]) {
                num++;
            } else {
                strb.append(sc[i]);
                strb.append(num);
                num = 1;
            }
            if (i + 2 == sc.length) {
                strb.append(sc[i + 1]);
                strb.append(num);
            }
        }

        return strb.length() < s.length() ? strb.toString() : s;
    }

}
