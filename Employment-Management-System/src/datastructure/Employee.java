package datastructure;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Serializable{
private int emp_id;
private String name;
private float salary;
private int phone;
private String email;
private String password;
private ArrayList<String> department=new ArrayList<String>();
private ArrayList<Manager> E_M=new ArrayList<Manager>();
public void addManager(Manager m){
	E_M.add(m);
}
public ArrayList<Manager> getManager(){
	return E_M;
}
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public ArrayList<String> getDepartment() {
	return department;
}
public void addDepartment(String d) {
	department.add(d);
}

}
