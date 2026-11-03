package com.sunbeam.three;


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {

    Node head;

   
    void addPosition(int data, int position) {

        Node newNode = new Node(data);

        
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }

      
        if (position == 1) {

            if (head == null) {
                head = newNode;
                newNode.next = head;
            } else {

                Node temp = head;

               
                while (temp.next != head) {
                    temp = temp.next;
                }

                newNode.next = head;
                temp.next = newNode;
                head = newNode;
            }

            return;
        }

        
        Node temp = head;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        if (temp.next == head && position > 1) {
           
            if (position != getSize() + 1) {
                System.out.println("Invalid position");
                return;
            }
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    
    void deletePosition(int position) {

        if (head == null || position < 1) {
            System.out.println("Invalid position or empty list");
            return;
        }

        
        if (position == 1) {

            
            if (head.next == head) {
                head = null;
                return;
            }

            Node temp = head;

            
            while (temp.next != head) {
                temp = temp.next;
            }

            head = head.next;
            temp.next = head;

            return;
        }

       
        Node temp = head;

        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        if (temp.next == head) {
            System.out.println("Invalid position");
            return;
        }

        temp.next = temp.next.next;
    }

    
    int getSize() {

        if (head == null) {
            return 0;
        }

        int count = 0;
        Node temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

   
    void display() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }
}

public class Test {

    public static void main(String[] args) {

        CircularLinkedList list = new CircularLinkedList();

        // Add nodes
        list.addPosition(10, 1);
        list.addPosition(20, 2);
        list.addPosition(30, 3);
        list.addPosition(40, 4);

        System.out.println("Original Circular Linked List:");
        list.display();

        // Add at position
        list.addPosition(25, 3);

        System.out.println("After inserting 25 at position 3:");
        list.display();

        // Delete at position
        list.deletePosition(2);

        System.out.println("After deleting position 2:");
        list.display();
    }
}
