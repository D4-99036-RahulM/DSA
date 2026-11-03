package com.sunbeam.five;

//Definition for singly-linked list.
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
 public ListNode middleNode(ListNode head) {
     // Use two pointers: slow moves 1 step, fast moves 2 steps
     ListNode slow = head;
     ListNode fast = head;
     
     // When fast reaches the end, slow will be exactly at the middle node
     while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
     }
     
     return slow;
 }
}

//Test class to execute the LeetCode examples
public class Main {
 
 // Helper method to create a linked list from an array
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

 // Helper method to print the linked list from a given node onwards
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

     // --- Example 1 (Odd number of nodes) ---
     System.out.println("--- Test Example 1 ---");
     int[] arr1 = {1, 2, 3, 4, 5};
     ListNode head1 = createLinkedList(arr1);
     System.out.print("Original List: ");
     printLinkedList(head1);
     
     ListNode middle1 = solver.middleNode(head1);
     System.out.print("From Middle:    ");
     printLinkedList(middle1); // Expected: 3 -> 4 -> 5
     System.out.println();

     // --- Example 2 (Even number of nodes) ---
     System.out.println("--- Test Example 2 ---");
     int[] arr2 = {1, 2, 3, 4, 5, 6};
     ListNode head2 = createLinkedList(arr2);
     System.out.print("Original List: ");
     printLinkedList(head2);
     
     ListNode middle2 = solver.middleNode(head2);
     System.out.print("From Middle:    ");
     printLinkedList(middle2); // Expected: 4 -> 5 -> 6
 }
}
