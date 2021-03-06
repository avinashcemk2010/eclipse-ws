package com.dsa.queue;

public class Main {

	public static void main(String[] args) {
		
		ArrayQueue queue = new ArrayQueue(10);
		
		queue.add(new Employee("Jane","Jones","123"));
		queue.add(new Employee("John","kerry","678"));
		queue.add(new Employee("Avinash","Jha","907"));
		queue.add(new Employee("Pretty","Woman","740"));
		
		System.out.println("Print queue");
		queue.printQueue();
		
		System.out.println("Peek");
		System.out.println(queue.peak());
		
		System.out.println("Print queue");
		queue.printQueue();
		
		System.out.println("Remove");
		System.out.println(queue.remove());
		
		System.out.println("Print queue");
		queue.printQueue();

	}

}
