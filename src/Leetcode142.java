import java.util.HashSet;

/**
 * @author lizehui
 * @date 2021/3/26 14:01
 */
public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if(set.contains(head)){
                return head;
            }else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
