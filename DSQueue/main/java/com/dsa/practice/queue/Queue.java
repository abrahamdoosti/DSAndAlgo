package com.dsa.practice.queue;

public class Queue {
	private String[] queueArray;
	private int front;
	private int rear;
	private int capacity;

	public Queue(int c) {
		front = 0;
		rear = 0;
		capacity = c;
		queueArray = new String[capacity];

	}

	public void enqueue(String value) {
		if (rear == capacity) {
			System.out.println("Queue is at full capacity");
			return;
		}
		queueArray[rear++] = value;
		System.out.println("The following is enqueued " + value);
	}
	
	// rear index is the location where we will add/enqueue new value, it is not the last element!
	public String dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		} else {
			String str = queueArray[front];
			for (int i = 0; i < rear - 1; i++) {
				queueArray[i] = queueArray[i + 1];
			}
			rear--;
			System.out.println("The following is dequeued " + str);
			return str;
		}

	}

	public String peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		} 
		else {
			String str = queueArray[front];
			System.out.println("The following is peeked "+str);
			return str;
		}

	}

	public boolean isFull() {
		return (rear == capacity);
	}

	public boolean isEmpty() {
		return (front == rear);
	}

}
