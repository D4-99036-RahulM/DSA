package com.sunbeam;

import java.util.Scanner;

public class LastOccurances {

	
		public static int linearSearchLastOccurrence(int[] arr, int key) {
	        int lastFoundIndex = -1;

	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] == key) {
	                lastFoundIndex = i;
	            }
	        }

	        return lastFoundIndex;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        
        int[] array = new int[n];

        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

       
        System.out.print("Enter the key to search for: ");
        int key = scanner.nextInt();

        
        int result = linearSearchLastOccurrence(array, key);

        if (result != -1) {
            System.out.println("The last occurrence of " + key + " is at index " + result);
        } else {
            System.out.println(key + " is not found in the array");
        }
        
        scanner.close();
    }
}

