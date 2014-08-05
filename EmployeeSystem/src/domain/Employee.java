package domain;

public class Employee {

	private int emp_id;
	private String emp_name;
	private float salary;
	private int phone;
	private String email;
	private String password;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
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

	public Employee(int emp_id, String emp_name, float salary, int phone,
			String email, String password) {
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.salary = salary;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

}
