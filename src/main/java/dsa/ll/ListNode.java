package dsa.ll;

import java.util.Objects;

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
        while (curentNode != null) {
            if (curentNode.next != null && curentNode.val == curentNode.next.val) {
                curentNode.next = curentNode.next.next;
            } else {
                curentNode = curentNode.next;
            }
        }

        return pointingNode.next;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        ListNode other = (ListNode) object;
        if (this.val != other.val) {
            return false;
        }

        ListNode current1 = this.next;
        ListNode current2 = other.next;

        while (current1 != null && current2 != null) {
            if (current1.val != current2.val) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1 == null && current2 == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
