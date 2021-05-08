import java.util.Stack;

/**
 * 逆波兰表达式求值
 */
public class Leetcode150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            int last;
            int first;
            switch (token) {
                case "+":
                    last = Integer.parseInt(stack.pop());
                    first = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(first + last));
                    break;
                case "-":
                    last = Integer.parseInt(stack.pop());
                    first = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(first - last));
                    break;
                case "*":
                    last = Integer.parseInt(stack.pop());
                    first = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(first * last));
                    break;
                case "/":
                    last = Integer.parseInt(stack.pop());
                    first = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(first / last));
                    break;
                default:
                    stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
