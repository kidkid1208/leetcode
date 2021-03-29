import org.w3c.dom.Node;

/**
 * @author lizehui
 * @date 2021/3/25 17:40
 */
public class Leetcode707 {
    static class MyLinkedList {


        class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        Node frontHead;

        int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            this.size = 0;
            frontHead = new Node(0);
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index > size - 1) {
                return -1;
            }
            Node temp = frontHead;
            while (index >= 0) {
                temp = temp.next;
                index--;
            }
            return temp.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the
         * linked list.
         */
        public void addAtHead(int val) {
            Node head = new Node(val);
            head.next = frontHead.next;
            frontHead.next = head;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            Node temp = frontHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(val);
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be
         * appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            Node temp = frontHead;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
            Node add = new Node(val);
            add.next = temp.next;
            temp.next = add;
            size++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index > size - 1) {
                return;
            }
            Node temp = frontHead;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(9);
        System.out.println(linkedList.get(1));
        linkedList.addAtIndex(1, 1);
        linkedList.addAtIndex(1, 7);
        linkedList.deleteAtIndex(1);
        linkedList.addAtHead(7);
        linkedList.addAtHead(4);
        linkedList.deleteAtIndex(1);
        linkedList.addAtIndex(1, 4);
        linkedList.addAtHead(2);
        linkedList.deleteAtIndex(5);
    }
}
