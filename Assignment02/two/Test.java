package com.sunbeam.two;

public class Test {
	public static void main(String[] args) {
		int size = 5;
		DescendingStack stack = new DescendingStack(size);

		System.out.println("--- Pushing Elements ---");
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);

		stack.push(60);

		System.out.println("\n--- Displaying Stack ---");
		stack.display();

		System.out.println("\n--- Popping Elements ---");
		System.out.println("Popped element: " + stack.pop());
		System.out.println("Popped element: " + stack.pop());

		System.out.println("\n--- Stack After Popping ---");
		stack.display();
	}
}

class DescendingStack {
	private int maxSize;
	private int[] stackArray;
	private int top;

	public DescendingStack(int size) {
		this.maxSize = size;
		this.stackArray = new int[maxSize];
		this.top = maxSize;
	}

	public boolean isFull() {
		return top == 0;
	}

	public boolean isEmpty() {
		return top == maxSize;
	}

	public void push(int value) {
		if (isFull()) {
			System.out.println("Stack Overflow! Cannot push " + value);
			return;
		}

		stackArray[--top] = value;
		System.out.println("Pushed: " + value + " (Top index: " + top + ")");
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow! No elements to pop.");
			return -1;
		}

		int poppedValue = stackArray[top];
		System.out.println("Removed index: " + top);
		top++;
		return poppedValue;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return;
		}
		System.out.print("Elements from top to bottom: ");
		for (int i = top; i < maxSize; i++) {
			System.out.print(stackArray[i] + " ");
		}
		System.out.println();
	}
}
