package datastructure;

import java.util.ArrayList;

public class Request {
private int emp_id;
private String name;
private float salary;
private int phone;
private String email;
private ArrayList<String> department=new ArrayList<String>();
public int getEmp_id() {
	return emp_id;
}
public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public ArrayList<String> getDepartment() {
	return department;
}
public void addDepartment(String department) {
	switch(department){
	case "11111":this.department.add("Human Resources");
				break;
	case "21111":this.department.add("Technology");
	break;
	case "31111":this.department.add("Marketing");
	break;
	case "41111":this.department.add("Finance");
	break;
	default:break;
	}
}
}
