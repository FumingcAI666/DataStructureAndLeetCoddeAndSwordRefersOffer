package leetcode.offer;

/**
 * @author macfmc
 * @date 2020/6/12-6:15
 */
public class 面试题05_替换空格 {
    public static void main(String[] args) {
        System.out.println(0xA<<2);
    }

    /**
     * 调用replace直接替换
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        String string = s.replace(" ", "%20");
        return string;
    }

    /**
     * 更像是replace的实现，遍历String，如果发现" "则更新数组
     * @param s
     * @return
     */
    public String replaceSpace1(String s) {

        StringBuilder res = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ')
                res.append("%20");
            else
                res.append(c);
        }
        return res.toString();
    }

}
