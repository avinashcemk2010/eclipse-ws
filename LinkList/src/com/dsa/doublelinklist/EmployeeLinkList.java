package com.dsa.doublelinklist;

public class EmployeeLinkList {

	private EmployeeNode head, tail;

	public static void main(String[] args) {
		Employee emp1 = new Employee("avinash","jha","avinash.jha@gmail.com");
		Employee emp2 = new Employee("Suresh","Raina","suresh.raina@gmail.com");
		Employee emp3 = new Employee("ratnesh","jha","ratnesh.jha@gmail.com");

		EmployeeLinkList employeeLinkList = new EmployeeLinkList();
		employeeLinkList.add(emp1);
		employeeLinkList.add(emp2);
		employeeLinkList.add(emp3);

		employeeLinkList.display();
	}

	public void add(Employee employee) {
		EmployeeNode employeeNode = new EmployeeNode();
		employeeNode.setEmployee(employee);
		if(head == null) {
			//add as first node
			employeeNode.setPrevious(null);
			employeeNode.setNext(null);
			head = tail = employeeNode;
		} else {
			employeeNode.setPrevious(tail);
			employeeNode.setNext(null);
			tail.setNext(employeeNode);
			tail = employeeNode;
		}
	}

	public void display() {
		EmployeeNode current = new EmployeeNode();
		current = head;
		while(current != null) {
			System.out.println(current.getEmployee());
			current = current.getNext();
		}
	}
}
