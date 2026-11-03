package com.sunbeam.four;

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
 public boolean isPalindrome(ListNode head) {
     if (head == null || head.next == null) {
         return true;
     }
     
     // 1. Find the end of the first half (middle node) using two pointers
     ListNode slow = head;
     ListNode fast = head;
     while (fast.next != null && fast.next.next != null) {
         slow = slow.next;
         fast = fast.next.next;
     }
     
     // 2. Reverse the second half of the linked list
     ListNode secondHalfHead = reverseList(slow.next);
     
     // 3. Compare values between the first half and the reversed second half
     ListNode p1 = head;
     ListNode p2 = secondHalfHead;
     boolean isPalin = true;
     while (isPalin && p2 != null) {
         if (p1.val != p2.val) {
             isPalin = false;
         }
         p1 = p1.next;
         p2 = p2.next;
     }
     
     // 4. Restore the list modification (Good practice!)
     slow.next = reverseList(secondHalfHead);
     
     return isPalin;
 }
 
 // Helper function to reverse a linked list in-place
 private ListNode reverseList(ListNode head) {
     ListNode prev = null;
     ListNode curr = head;
     while (curr != null) {
         ListNode nextTemp = curr.next;
         curr.next = prev;
         prev = curr;
         curr = nextTemp;
     }
     return prev;
 }
}

//Test class to execute the LeetCode examples
public class Main {
 
 // Helper method to dynamically instantiate lists from basic arrays
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

 public static void main(String[] args) {
     Solution solver = new Solution();

     // --- Example 1 ---
     System.out.println("--- Test Example 1 ---");
     int[] arr1 = {1, 2, 2, 1};
     ListNode head1 = createLinkedList(arr1);
     System.out.println("Is Palindrome? Expected: true  | Actual: " + solver.isPalindrome(head1));
     System.out.println();

     // --- Example 2 ---
     System.out.println("--- Test Example 2 ---");
     int[] arr2 = {1, 2};
     ListNode head2 = createLinkedList(arr2);
     System.out.println("Is Palindrome? Expected: false | Actual: " + solver.isPalindrome(head2));
 }
}
