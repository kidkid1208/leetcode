import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * 输入：s = "()[]{}"
 * 输出：true
 */
public class Leetcode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '[':
                case '{':
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.pop() == '(') {
                        break;
                    }
                    return false;
                case ']':
                    if (!stack.isEmpty() && stack.pop() == '[') {
                        break;
                    }
                    return false;
                case '}':
                    if (!stack.isEmpty() && stack.pop() == '{') {
                        break;
                    }
                    return false;
                default:
            }
        }
        return stack.isEmpty();
    }
}
