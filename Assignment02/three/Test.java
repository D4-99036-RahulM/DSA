package com.sunbeam.three;

public class Test {
	public static void main(String[] args) {
		int size = 5;
		CircularQueue queue = new CircularQueue(size);

		System.out.println("--- Enqueuing Elements ---");
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);

		queue.enqueue(60);

		System.out.println("\n--- Displaying Queue ---");
		queue.display();

		System.out.println("\n--- Dequeuing Elements ---");
		System.out.println("Dequeued element: " + queue.dequeue());
		System.out.println("Dequeued element: " + queue.dequeue());

		System.out.println("\n--- Queue State After Dequeuing ---");
		queue.display();

		System.out.println("\n--- Enqueuing into Circular Vacancy ---");
		queue.enqueue(60);
		queue.enqueue(70);

		System.out.println("\n--- Final Queue State ---");
		queue.display();
	}
}

class CircularQueue {
	private int maxSize;
	private int[] queueArray;
	private int front;
	private int rear;
	private int count;

	public CircularQueue(int size) {
		this.maxSize = size;
		this.queueArray = new int[maxSize];
		this.front = 0;
		this.rear = -1;
		this.count = 0;
	}

	public boolean isFull() {
		return count == maxSize;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void enqueue(int value) {
		if (isFull()) {
			System.out.println("Queue Overflow! Cannot enqueue " + value);
			return;
		}

		rear = (rear + 1) % maxSize;
		queueArray[rear] = value;
		count++;
		System.out.println("Enqueued: " + value + " (Rear index: " + rear + ", Total items: " + count + ")");
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue Underflow! No elements to dequeue.");
			return -1;
		}

		int dequeuedValue = queueArray[front];
		front = (front + 1) % maxSize;
		count--;
		return dequeuedValue;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		System.out.print("Queue elements: ");
		int index = front;
		for (int i = 0; i < count; i++) {
			System.out.print(queueArray[index] + " ");
			index = (index + 1) % maxSize;
		}
		System.out.println("\n[Front Index: " + front + ", Rear Index: " + rear + ", Count: " + count + "]");
	}
}
