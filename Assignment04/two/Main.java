package com.sunbeam.two;


class ListNode {
 int val;
 ListNode next;
 
 ListNode() {}
 
 ListNode(int val) { 
     this.val = val; 
 }
 
 ListNode(int val, ListNode next) { 
     this.val = val; 
     this.next = next; 
 }
}

class Solution {
 public ListNode reverseBetween(ListNode head, int left, int right) {
     if (head == null || left == right) {
         return head;
     }
     
     // A dummy node helps seamlessly handle cases where 'left' is 1 (reversing from the head)
     ListNode dummy = new ListNode(0);
     dummy.next = head;
     
     // 1. Move prev pointer to the node right before the sub-list to reverse
     ListNode prev = dummy;
     for (int i = 0; i < left - 1; i++) {
         prev = prev.next;
     }
     
     // 2. Perform localized in-place link adjustments
     ListNode start = prev.next; // The first node of the sub-list to be reversed
     ListNode then = start.next; // The node that will be moved ahead of 'start'
     
     // Loop runs exactly (right - left) times
     for (int i = 0; i < right - left; i++) {
         start.next = then.next;
         then.next = prev.next;
         prev.next = then;
         then = start.next;
     }
     
     return dummy.next;
 }
}

//Test class to verify the solution
public class Main {
 
 //  method to create a linked list from an array
 public static ListNode createLinkedList(int[] arr) {
     if (arr == null || arr.length == 0) return null;
     ListNode dummy = new ListNode(0);
     ListNode current = dummy;
     for (int val : arr) {
         current.next = new ListNode(val);
         current = current.next;
     }
     return dummy.next;
 }

 // method to print the linked list
 public static void printLinkedList(ListNode head) {
     ListNode current = head;
     while (current != null) {
         System.out.print(current.val);
         if (current.next != null) {
             System.out.print(" -> ");
         }
         current = current.next;
     }
     System.out.println();
 }

 public static void main(String[] args) {
     Solution solver = new Solution();

     // --- Example 1 ---
     System.out.println("--- Test Example 1 ---");
     int[] arr1 = {1, 2, 3, 4, 5};
     int left1 = 2, right1 = 4;
     
     ListNode head1 = createLinkedList(arr1);
     System.out.print("Original List: ");
     printLinkedList(head1);
     
     ListNode result1 = solver.reverseBetween(head1, left1, right1);
     System.out.print("Result List:   ");
     printLinkedList(result1);
     System.out.println();

     // --- Example 2 ---
     System.out.println("--- Test Example 2 ---");
     int[] arr2 = {5};
     int left2 = 1, right2 = 1;
     
     ListNode head2 = createLinkedList(arr2);
     System.out.print("Original List: ");
     printLinkedList(head2);
     
     ListNode result2 = solver.reverseBetween(head2, left2, right2);
     System.out.print("Result List:   ");
     printLinkedList(result2);
 }
}
