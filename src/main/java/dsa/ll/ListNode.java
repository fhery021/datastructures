package dsa.ll;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    public ListNode append(int value) {
        ListNode newNode = new ListNode(value);
        next = newNode;
        return newNode;
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode leftTail = left;
        ListNode rightTail = right;
        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = right.next;
        rightTail.next = null;
        return left.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curentNode = head;
        ListNode pointingNode = new ListNode(0);
        pointingNode.next = curentNode;
        while(curentNode != null) {
            if (curentNode.next != null && curentNode.val == curentNode.next.val){
                curentNode.next = curentNode.next.next;
            } else {
                curentNode = curentNode.next;
            }
        }

        return pointingNode.next;
    }

}
