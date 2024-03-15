package dsa.ll;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

public class MyLinkedList {

    private Node head;
    private Node tail;

    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public MyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        Node curentNode;
    }

    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public Node findKthFromEnd(int k) {
        Node fast = head;
        Node slow = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();
        Node curentNode = head;
        while (curentNode != null) {
            values.add(curentNode.value);
            curentNode = curentNode.next;
        }

        head = null;
        for (Integer value : values) {
            append(value);
        }
        length = values.size();
    }

    public void reverseBetween(int start, int finish) {
        Node currentNode = head;
        Node before = currentNode;
        int index = 0;
        while (index < start && currentNode != null) {
            before.next = currentNode.next;
            currentNode = currentNode.next;
            index++;
        }

        while (index >= start && index <= finish && currentNode != null) {
            int distance = finish - index;
            Node nextNode = currentNode;
            while (distance >= 0) {
                nextNode = nextNode.next;
                distance--;
            }
            if (nextNode != null) {
                before.next = nextNode;
            }
            currentNode = currentNode.next;
            index++;
        }

        while (index > finish && currentNode != null) {
            before.next = currentNode.next;
            currentNode = currentNode.next;
            index++;
        }

    }
}
