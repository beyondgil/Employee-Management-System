package datastructure;

import java.io.Serializable;
import java.util.ArrayList;

public class Manager implements Serializable{
	private int man_id;
	private int emp_id;
	private String name;
	private float salary;
	private int phone;
	private String email;
	private String password;
	private ArrayList<Employee> M_E=new ArrayList<Employee>();
	private String department;
	public int getMan_id() {
		return man_id;
	}
	public void setMan_id(int man_id) {
		this.man_id = man_id;
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
	public ArrayList<Employee> getEmployee() {
		return M_E;
	}
	public void addEmployee(Employee e) {
		M_E.add(e);
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}
