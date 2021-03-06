package com.dsa.doublelinklist;

public class EmployeeNode {
	
	private Employee employee;
	private EmployeeNode next;
	private EmployeeNode previous;
	
	public EmployeeNode() {}

	public EmployeeNode(Employee employee, EmployeeNode employeeNode, EmployeeNode previous) {
		super();
		this.employee = employee;
		this.next = employeeNode;
		this.previous = previous;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeNode getNext() {
		return next;
	}

	public void setNext(EmployeeNode employeeNode) {
		this.next = employeeNode;
	}
	
	public EmployeeNode getPrevious() {
		return previous;
	}

	public void setPrevious(EmployeeNode previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return "EmployeeNode [employee=" + employee + ", next=" + next + ", previous=" + previous + "]";
	}

}
