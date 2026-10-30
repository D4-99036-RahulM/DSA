package com.sunbeam.one;

public class Test {

   
    static class LinearQueue {
        private int[] queue;
        private int front;
        private int rear;
        private int capacity;

        
        public LinearQueue(int size) {
            this.capacity = size;
            this.queue = new int[capacity];
            this.front = 0;
            this.rear = 0;
        }

       
        public void enqueue(int data) {
          
            if (rear == capacity) {
                System.out.println("Queue Overflow! Cannot enqueue " + data);
                return;
            }
            
           
            queue[rear] = data;
            rear++;
            System.out.println("Enqueued: " + data);
        }

        
        public int dequeue() {
            
            if (front == rear) {
                System.out.println("Queue Underflow! Nothing to dequeue.");
                return -1;
            }

           
            int data = queue[front];
            System.out.println("Dequeued: " + data);
            front++;
            
            return data;
        }

        
        public int peek() {
            if (front == rear) {
                System.out.println("Queue is empty.");
                return -1;
            }
            return queue[front];
        }

        
        public void display() {
            if (front == rear) {
                System.out.println("Queue is empty.");
                return;
            }
            
            System.out.print("Queue elements: ");
            for (int i = front; i < rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    } 

    public static void main(String[] args) {
       
        LinearQueue q = new LinearQueue(3);

       
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40); 

        q.display();

        
        System.out.println("Front element is: " + q.peek());
        q.dequeue();
        q.display();
        
        q.dequeue();
        q.dequeue();
        q.dequeue(); 
    }
} 
