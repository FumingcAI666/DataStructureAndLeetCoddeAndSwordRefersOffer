package cs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author macfmc
 * @date 2020/6/13-22:30
 */
public class ReversePolishNotation {

    /**
     * 测试的main方法
     */
    public static void main(String arg[]) {
        String s = "9+(3-1)*3+10/2";
        ArrayList postfix = transform(s);
        for (int i = 0, len = postfix.size(); i < len; i++) {
            System.out.println(postfix.get(i));
        }
        calculate(postfix);
    }

    /**
     * 将中缀表达式转换成后缀表达式
     */
    public static ArrayList transform(String prefix) {
        System.out.println("transform");
        int i, len = prefix.length();// 用字符串保存前缀表达式
        prefix = prefix + '#';// 让前缀表达式以'#'结尾
        Stack<Character> stack = new Stack<Character>();// 保存操作符的栈
        stack.push('#');// 首先让'#'入栈
        ArrayList postfix = new ArrayList();//后缀数组集合

        // 保存后缀表达式的列表,可能是数字，也可能是操作符
        for (i = 0; i < len + 1; i++) {
            System.out.println(i + " " + prefix.charAt(i));
            if (Character.isDigit(prefix.charAt(i))) {// 当前字符是一个数字
                if (Character.isDigit(prefix.charAt(i + 1))) {// 当前字符的下一个字符也是数字(两位数)
                    postfix.add(10 * (prefix.charAt(i) - '0') + (prefix.charAt(i + 1) - '0'));
                    i++;// 序号加1
                } else {// 当前字符的下一个字符不是数字(一位数)
                    postfix.add((prefix.charAt(i) - '0'));
                }
            } else {// 当前字符是一个操作符
                switch (prefix.charAt(i)) {
                    case '(':// 如果是开括号
                        stack.push(prefix.charAt(i));// 开括号只放入到栈中，不放入到后缀表达式中
                        break;
                    case ')':// 如果是闭括号
                        while (stack.peek() != '(') {
                            postfix.add(stack.pop());// 闭括号不入栈，将前一个不是“）”的操作符入栈
                        }
                        stack.pop();// '('出栈
                        break;
                    default:// 默认情况下:+ - * /
                        while (stack.peek() != '#' && compare(stack.peek(), prefix.charAt(i))) {// 比较运算符之间的优先级
                            postfix.add(stack.pop());// 不断弹栈，直到当前的操作符的优先级高于栈顶操作符
                        }
                        if (prefix.charAt(i) != '#') {// 如果当前的操作符不是'#'(结束符)，那么入操作符栈
                            stack.push(prefix.charAt(i));// 最后的标识符'#'是不入栈的
                        }
                        break;
                }
            }
        }
        return postfix;
    }

    /**
     * 比较运算符之间的优先级
     * 如果是peek优先级高于cur，返回true，默认都是peek优先级要低
     */
    public static boolean compare(char peek, char cur) {
        if (peek == '*'
                && (cur == '+' || cur == '-' || cur == '/' || cur == '*')) {// 如果cur是'('，那么cur的优先级高,如果是')'，是在上面处理
            return true;
        } else if (peek == '/'
                && (cur == '+' || cur == '-' || cur == '*' || cur == '/')) {
            return true;
        } else if (peek == '+' && (cur == '+' || cur == '-')) {
            return true;
        } else if (peek == '-' && (cur == '+' || cur == '-')) {
            return true;
        } else if (cur == '#') {// 这个很特别，这里说明到了中缀表达式的结尾，那么就要弹出操作符栈中的所有操作符到后缀表达式中
            return true;// 当cur为'#'时，cur的优先级算是最低的
        }
        return false;// 开括号是不用考虑的，它的优先级一定是最小的,cur一定是入栈
    }

    /**
     * 计算后缀表达式
     */
    public static double calculate(ArrayList postfix) {// 后缀表达式的运算顺序就是操作符出现的先后顺序
        System.out.println("calculate");
        int i, res = 0, size = postfix.size();
        Stack<Integer> stackNum = new Stack<Integer>();
        for (i = 0; i < size; i++) {
            if (postfix.get(i).getClass() == Integer.class) {// 判断如果是操作数
                stackNum.push((Integer) postfix.get(i));//入栈
                System.out.println("push" + " " + (Integer) postfix.get(i));
            } else {// 如果是操作符
                System.out.println((Character) postfix.get(i));
                int a = stackNum.pop();// 出栈后一个操作数
                int b = stackNum.pop();// 出栈前一个操作数
                switch ((Character) postfix.get(i)) {
                    case '+':
                        res = b + a;
                        System.out.println("+ " + a + " " + b);
                        break;
                    case '-':
                        res = b - a;
                        System.out.println("- " + a + " " + b);
                        break;
                    case '*':
                        res = b * a;
                        System.out.println("* " + a + " " + b);
                        break;
                    case '/':
                        res = b / a;
                        System.out.println("/ " + a + " " + b);
                        break;
                }
                stackNum.push(res);//操作后的结果入栈
                System.out.println("push" + " " + res);
            }
        }
        res = stackNum.pop();//结果
        System.out.println("结果： " + " " + res);
        return res;
    }
}