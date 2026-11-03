package com.sunbeam.one;


class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {

    Node head;

    
    void insert(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

   
    void reverseIterative() {

        Node prev = null;
        Node current = head;

        while (current != null) {

            
            Node next = current.next;

            // Reverse the link
            current.next = prev;

            // Move prev forward
            prev = current;

            // Move current forward
            current = next;
        }

        // Update head
        head = prev;
    }

    
    Node reverseRecursive(Node head) {

       
        if (head == null || head.next == null) {
            return head;
        }

      
        Node newHead = reverseRecursive(head.next);

       
        head.next.next = head;

        
        head.next = null;

        return newHead;
    }

    
    void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}

public class Test {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.println("Original Linked List:");
        list.display();

        
        list.reverseIterative();

        System.out.println("After Iterative Reversal:");
        list.display();

       
        list.head = list.reverseRecursive(list.head);

        System.out.println("After Recursive Reversal:");
        list.display();
    }
}
