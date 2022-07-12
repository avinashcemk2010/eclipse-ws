package com.dsa.stack;

public class Main {

	public static void main(String[] args) {
		
		Stack stack = new Stack(10);
		
		stack.push(new Employee("Jane","Jones",123));
		stack.push(new Employee("John","kerry",678));
		stack.push(new Employee("Avinash","Jha",907));
		stack.push(new Employee("Pretty","Woman",740));
		
		System.out.println("Print Stack");
		stack.printStack();
		
		System.out.println("Peek");
		System.out.println(stack.peek());
		
		System.out.println("Print Stack");
		stack.printStack();
		
		System.out.println("POP");
		System.out.println(stack.pop());
		
		System.out.println("Print stack");
		stack.printStack();

	}

}
