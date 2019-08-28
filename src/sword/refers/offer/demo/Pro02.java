package sword.refers.offer.demo;

/**
 * 时间限制：1秒 空间限制：32768K
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author macfmc
 * @date 2019/8/26-17:28
 */
public class Pro02 {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(stringBuffer));
    }

    public static String replaceSpace(StringBuffer str) {
        // StringBuffer转换为Stirng，在进行替换函数替换
        String str1 = String.valueOf(str).replace(" ", "%20");
        return str1;
    }
}