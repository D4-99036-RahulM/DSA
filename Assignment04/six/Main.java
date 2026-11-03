package com.sunbeam.six;


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
 public ListNode deleteMiddle(ListNode head) {
     
     if (head == null || head.next == null) {
         return null;
     }
     
     
     ListNode slow = head;
     ListNode fast = head.next.next;
     
     while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
     }
     
    
     slow.next = slow.next.next;
     
     return head;
 }
}


public class Main {
 
 
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

 
 public static void printLinkedList(ListNode head) {
     if (head == null) {
         System.out.println("[] (Empty List)");
         return;
     }
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
     int[] arr1 = {1, 3, 4, 7, 1, 2, 6};
     ListNode head1 = createLinkedList(arr1);
     System.out.print("Original List: ");
     printLinkedList(head1);
     
     ListNode result1 = solver.deleteMiddle(head1);
     System.out.print("After Deletion: ");
     printLinkedList(result1); 
     System.out.println();

     // --- Example 2 ---
     System.out.println("--- Test Example 2 ---");
     int[] arr2 = {1, 2, 3, 4};
     ListNode head2 = createLinkedList(arr2);
     System.out.print("Original List: ");
     printLinkedList(head2);
     
     ListNode result2 = solver.deleteMiddle(head2);
     System.out.print("After Deletion: ");
     printLinkedList(result2); 
     System.out.println();

     // --- Example 3 ---
     System.out.println("--- Test Example 3 ---");
     int[] arr3 = {2, 1};
     ListNode head3 = createLinkedList(arr3);
     System.out.print("Original List: ");
     printLinkedList(head3);
     
     ListNode result3 = solver.deleteMiddle(head3);
     System.out.print("After Deletion: ");
     printLinkedList(result3);
 }
}
