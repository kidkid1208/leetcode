import java.util.LinkedList;

/**
 * @author lizehui
 * @date 2021/4/6 10:27
 */
public class Leetcode225 {
    static class MyStack {

        LinkedList<Integer> que1;
        LinkedList<Integer> que2;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            que1 = new LinkedList<>();
            que2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            que1.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int size = que1.size();
            size--;
            while (size > 0) { // 将que1 导入que2，但要留下最后一个元素
                que2.offer(que1.peek());
                que1.poll();
                size--;
            }

            int result = que1.peek(); // 留下的最后一个元素就是要返回的值
            que1.poll();
            while (!que2.isEmpty()) { // 清空que2
                que1.add(que2.poll());
            }
            return result;
        }

        /**
         * Get the top element.
         */
        public int top() {
            return que1.getLast();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return que1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());

    }
}
