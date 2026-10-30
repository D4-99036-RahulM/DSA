package com.sunbeam.four;

import java.util.Stack;


public class Test {
 public static void main(String[] args) {
     // Test Postfix Expression: (12 * 4) + (100 / 5) - 2 = 48 + 20 - 2 = 66
     String postfixExpr = "12 4 * 100 5 / + 2 -";
     
    
     String prefixExpr = "- + * 12 4 / 100 5 2";

     System.out.println("--- Testing Postfix Evaluation ---");
     System.out.println("Expression: " + postfixExpr);
     System.out.println("Result: " + ExpressionEvaluator.evaluatePostfix(postfixExpr));

     System.out.println("\n--- Testing Prefix Evaluation ---");
     System.out.println("Expression: " + prefixExpr);
     System.out.println("Result: " + ExpressionEvaluator.evaluatePrefix(prefixExpr));
 }
}


class ExpressionEvaluator {


 private static boolean isOperator(String token) {
     return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
 }

 
 private static int applyOp(String op, int b, int a) {
     switch (op) {
         case "+": return b + a;
         case "-": return b - a;
         case "*": return b * a;
         case "/": 
             if (a == 0) throw new ArithmeticException("Division by zero!");
             return b / a;
         default: return 0;
     }
 }

 
 public static int evaluatePostfix(String expression) {
     Stack<Integer> stack = new Stack<>();
     
     String[] tokens = expression.split("\\s+");

     for (String token : tokens) {
         if (token.isEmpty()) continue;

         if (isOperator(token)) {
            
             int operand2 = stack.pop();
             int operand1 = stack.pop();
             int result = applyOp(token, operand1, operand2);
             stack.push(result);
         } else {
             
             stack.push(Integer.parseInt(token));
         }
     }
     return stack.pop();
 }

 
 public static int evaluatePrefix(String expression) {
     Stack<Integer> stack = new Stack<>();
     
     String[] tokens = expression.split("\\s+");

     
     for (int i = tokens.length - 1; i >= 0; i--) {
         String token = tokens[i];
         if (token.isEmpty()) continue;

         if (isOperator(token)) {
             
             int operand1 = stack.pop();
             int operand2 = stack.pop();
             int result = applyOp(token, operand1, operand2);
             stack.push(result);
         } else {
             
             stack.push(Integer.parseInt(token));
         }
     }
     return stack.pop();
 }
}
