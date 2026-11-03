package com.sunbeam;

import java.util.Scanner;

public class NthOccurance {

    public static void main(String[] args) {
        
        int[] arr = {11, 22, 33, 22, 44, 55, 22, 66};
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter key to be searched: ");
        int key = scanner.nextInt();
        
        System.out.print("Enter which occurrence you want to find ( 1 for first, 2 for second): ");
        int n = scanner.nextInt();
        
        int index = findNthOccurrence(arr, key, n);
        
        if (index != -1) {
            System.out.println("Occurrence " + n + " of key " + key + " is found at index: " + index);
        } else {
            System.out.println("Occurrence " + n + " of key " + key + " was not found in the array.");
        }
        
        scanner.close();
    } 
    public static int findNthOccurrence(int[] arr, int key, int n) {
        if (n <= 0) {
            return -1;
        }

        int occurrenceCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                occurrenceCount++; 
                if (occurrenceCount == n) {
                    return i;
                }
            }
        }

        return -1;
    }
} 
