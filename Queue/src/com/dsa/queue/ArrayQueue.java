package com.dsa.queue;

import java.util.NoSuchElementException;

public class ArrayQueue {
	
	private Employee[] queue;
	private int front;
	private int back;
	
	public ArrayQueue(int capacity) {
		queue = new Employee[capacity];
	}
	
	public void add(Employee employee) {
		if(back == queue.length) {
			Employee[] newArray = new Employee[2*queue.length];
			System.arraycopy(queue, 0, newArray, 0, queue.length);
		}
		queue[back] = employee;
		back++;
	}
	
	public Employee remove() {
		if(size()==0) {
			front = back = 0;
			throw new NoSuchElementException();
		}
		Employee employee = queue[front];
		queue[front] = null;
		front++;
		
		return employee;
	}
	
	public Employee peak() {
		if(size() == 0) {
			throw new NoSuchElementException();
		}
		return queue[front];
	}
	
	public void printQueue() {
		for(int i=front;i<back;i++) {
			System.out.println(queue[i]);
		}
	}
	
	public int size() {
		return back-front;
	}

}
