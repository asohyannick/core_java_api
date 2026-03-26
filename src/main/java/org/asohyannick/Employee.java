package org.asohyannick;

public class Employee {
 private  String name;
 private String department;
 private int salary;
 
 public Employee(String name, String department, int salary) {
	 this.name = name;
	 this.department = department;
	 this.salary = salary;
 }

public Employee(String name, String department) {
	this(name, department, 50_000);  // default salary
}

public Employee(String name) {
	this(name, "General");           // default department too
}

}
