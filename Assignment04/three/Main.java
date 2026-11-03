package com.sunbeam.three;

//Definition for singly-linked list.
class ListNode {
 int val;
 ListNode next;
 
 ListNode(int x) {
     val = x;
     next = null;
 }
}

class Solution {
 public boolean hasCycle(ListNode head) {
    
     if (head == null || head.next == null) {
         return false;
     }
     
     ListNode slow = head;
     ListNode fast = head;
     
     
     while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
         
         
         if (slow == fast) {
             return true;
         }
     }
     
    
     return false;
 }
}

//Test class to build and verify linked lists with cycles
public class Main {

 // Helper method to create a linked list and optionally introduce a cycle
 public static ListNode createLinkedListWithCycle(int[] arr, int pos) {
     if (arr == null || arr.length == 0) return null;
     
     ListNode head = new ListNode(arr[0]);
     ListNode current = head;
     ListNode cycleNode = (pos == 0) ? head : null;
     
     for (int i = 1; i < arr.length; i++) {
         current.next = new ListNode(arr[i]);
         current = current.next;
         if (i == pos) {
             cycleNode = current;
         }
     }
     
     // Connect the tail to the node at index 'pos' to form a cycle
     if (pos != -1 && cycleNode != null) {
         current.next = cycleNode;
     }
     
     return head;
 }

 public static void main(String[] args) {
     Solution solver = new Solution();

     // --- Example 1 ---
     System.out.println("--- Test Example 1 ---");
     int[] arr1 = {3, 2, 0, -4};
     int pos1 = 1; // Tail connects to node index 1 (value 2)
     ListNode head1 = createLinkedListWithCycle(arr1, pos1);
     System.out.println("Has Cycle? Expected: true | Actual: " + solver.hasCycle(head1));
     System.out.println();

     // --- Example 2 ---
     System.out.println("--- Test Example 2 ---");
     int[] arr2 = {1, 2};
     int pos2 = 0; // Tail connects to node index 0 (value 1)
     ListNode head2 = createLinkedListWithCycle(arr2, pos2);
     System.out.println("Has Cycle? Expected: true | Actual: " + solver.hasCycle(head2));
     System.out.println();

     // --- Example 3 ---
     System.out.println("--- Test Example 3 ---");
     int[] arr3 = {1};
     int pos3 = -1; // No cycle
     ListNode head3 = createLinkedListWithCycle(arr3, pos3);
     System.out.println("Has Cycle? Expected: false | Actual: " + solver.hasCycle(head3));
 }
}
