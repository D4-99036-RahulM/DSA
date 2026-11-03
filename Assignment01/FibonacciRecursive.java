package com.sunbeam;

import java.util.Scanner;

public class FibonacciRecursive {

   
    public static int findNthFibonacci(int n) {
              if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        
        return findNthFibonacci(n - 1) + findNthFibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the term position (n) to find: ");
        int n = scanner.nextInt();
        
        if (n < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            int result = findNthFibonacci(n);
            System.out.println("The " + n + "th term of the Fibonacci series is: " + result);
        }
        
        scanner.close();
    }
}
