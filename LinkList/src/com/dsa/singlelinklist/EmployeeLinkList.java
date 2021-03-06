package com.dsa.singlelinklist;

public class EmployeeLinkList {
	
	private EmployeeNode head = null;
	private EmployeeNode tail = null;

	public static void main(String[] args) {
		Employee emp1 = new Employee("avinash","jha","avinash.jha@gmail.com");
		Employee emp2 = new Employee("Suresh","Raina","suresh.raina@gmail.com");
		Employee emp3 = new Employee("ratnesh","jha","ratnesh.jha@gmail.com");
		
		EmployeeLinkList employeeLinkList = new EmployeeLinkList();
		employeeLinkList.addNode(emp1);
		employeeLinkList.addNode(emp2);
		employeeLinkList.addNode(emp3);
		
		employeeLinkList.display();
	}
	
	public void addNode(Employee emp) {
		EmployeeNode employeeNode = new EmployeeNode();
		employeeNode.setEmployee(emp);
		employeeNode.setNext(null);
		
		//add a node as first node
		if(head == null) {
			head = employeeNode;
			tail = employeeNode;
		} else {
			tail.setNext(employeeNode);
			tail = employeeNode;
		}
	}
	
	public void display() {
		EmployeeNode current = head;
		while(current != null) {
			System.out.println(current.getEmployee().getFirstName());
			current = current.getNext();
		}
	}

}
