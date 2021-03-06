package com.dsa.singlelinklist;

public class EmployeeNode {
	
	private Employee employee;
	private EmployeeNode next;
	
	public EmployeeNode() {}

	public EmployeeNode(Employee employee, EmployeeNode employeeNode) {
		super();
		this.employee = employee;
		this.next = employeeNode;
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
	
	@Override
	public String toString() {
		return super.toString();
	}

}
