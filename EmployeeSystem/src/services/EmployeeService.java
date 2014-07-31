package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.Department;
import domain.Employee;

public class EmployeeService {

	private List<Employee> emp_list = new ArrayList<Employee>();

	// private static EmployeeService reference;
	//
	// public static EmployeeService getService() {
	// if (reference == null) {
	// reference = new EmployeeService();
	// }
	// return reference;
	// }

	public EmployeeService() {

		String usr = "admin";
		String pwd = "123456";
		String url = "jdbc:mysql://localhost:3306/DB2";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success loading Driver!");
		}

		catch (Exception e) {
			System.out.println("Fail loading Driver!");
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Success connecting server!");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

			while (rs.next()) {

				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				float salary = rs.getFloat("salary");
				int phone = rs.getInt("phone");
				String email = rs.getString("email");
				String password = rs.getString("password");

				Employee employee = new Employee(emp_id, emp_name, salary,
						phone, email, password);
				emp_list.add(employee);

			}

		}

		catch (SQLException e) {
			System.out
					.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}

	}

	public Employee getEmployeeById(int emp_id) {

		for (Employee next : emp_list) {
			if (next.getEmp_id() == emp_id) {
				Employee returnEmployee = new Employee(next.getEmp_id(),
						next.getEmp_name(), next.getSalary(), next.getPhone(),
						next.getEmail(), next.getPassword());
				return returnEmployee;
			}
		}
		System.out.println("Can not find the employee.");
		return null;

	}

	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(emp_list);
	}

	public void registerNewEmployee(Employee newEmployee) {

		String usr = "admin";
		String pwd = "123456";
		String url = "jdbc:mysql://localhost:3306/DB2";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success loading Driver!");
		}

		catch (Exception e) {
			System.out.println("Fail loading Driver!");
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Success connecting server!");

			Statement stmt = conn.createStatement();

			Iterator<Employee> it = emp_list.iterator();
			while (it.hasNext()) {
				if (((Employee) it.next()).getEmp_id() == newEmployee
						.getEmp_id()) {
					System.out.println("Employee already exists.");
					return;
				}
			}

			stmt.executeUpdate("INSERT INTO employee VALUES(" + "'"
					+ Integer.toString(newEmployee.getEmp_id()) + "'" + ","
					+ "'" + newEmployee.getEmp_name() + "'" + "," + "'"
					+ Float.toString(newEmployee.getSalary()) + "'" + "," + "'"
					+ Integer.toString(newEmployee.getPhone()) + "'" + ","
					+ "'" + newEmployee.getEmail() + "'" + "," + "'"
					+ newEmployee.getPassword() + "'" + ")");

		} catch (SQLException e) {
			System.out
					.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}

	}

	public void deleteEmployee(Employee employeeToRemove) {

		String usr = "admin";
		String pwd = "123456";
		String url = "jdbc:mysql://localhost:3306/DB2";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success loading Driver!");
		}

		catch (Exception e) {
			System.out.println("Fail loading Driver!");
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Success connecting server!");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

			while (rs.next()) {
				if (rs.getInt("emp_id") == employeeToRemove.getEmp_id()) {
					stmt.executeUpdate("DELETE FROM employee WHERE emp_id = "
							+ "'" + employeeToRemove.getEmp_id() + "'");
					return;
				}
			}
			System.out.println("Do not find the employee.");

		} catch (SQLException e) {
			System.out
					.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}

	}

	public Employee getNewlyJoinedEmployee() {
		return emp_list.get(emp_list.size() - 1);
	}

	public List<Employee> getEmployeeByDepartment(int dep_id) {

		List<Employee> returnList = new ArrayList<>();

		String usr = "admin";
		String pwd = "123456";
		String url = "jdbc:mysql://localhost:3306/DB2";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success loading Driver!");
		}

		catch (Exception e) {
			System.out.println("Fail loading Driver!");
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Success connecting server!");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * "
					+ "FROM employee as T, emp_dep as S "
					+ "WHERE T.emp_id = S.emp_id and S.dep_id = " + "'"
					+ dep_id + "'");

			while (rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				float salary = rs.getFloat("salary");
				int phone = rs.getInt("phone");
				String email = rs.getString("email");
				String password = rs.getString("password");

				Employee employee = new Employee(emp_id, emp_name, salary,
						phone, email, password);

				returnList.add(employee);
			}

		} catch (SQLException e) {
			System.out
					.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}
		return returnList;

	}

	public Department getMinimumDepartment() {

		Department minDepartment = new Department(0, null, 0);

		String usr = "admin";
		String pwd = "123456";
		String url = "jdbc:mysql://localhost:3306/DB2";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success loading Driver!");
		}

		catch (Exception e) {
			System.out.println("Fail loading Driver!");
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Success connecting server!");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * " + "from department "
					+ "where dep_id in " + "(select dep_id " + "from emp_dep "
					+ "group by dep_id "
					+ "having count(distinct emp_id)<=all("
					+ "select count(distinct emp_id) " + "from emp_dep "
					+ "group by dep_id))");

			if (rs.next()) {
				int dep_id = rs.getInt("dep_id");
				String dep_name = rs.getString("dep_name");
				int man_id = rs.getInt("man_id");

				minDepartment.setDep_id(dep_id);
				minDepartment.setDep_name(dep_name);
				minDepartment.setMan_id(man_id);
			}

		} catch (SQLException e) {
			System.out
					.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}
		return minDepartment;

	}

	public List<Employee> getSameSalaryEmployee() {

		List<Employee> returnList = new ArrayList<>();

		String usr = "admin";
		String pwd = "123456";
		String url = "jdbc:mysql://localhost:3306/DB2";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success loading Driver!");
		}

		catch (Exception e) {
			System.out.println("Fail loading Driver!");
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Success connecting server!");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from employee where salary in (select salary from employee group by salary having count(*)>1) order by salary");

			while (rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				float salary = rs.getFloat("salary");
				int phone = rs.getInt("phone");
				String email = rs.getString("email");
				String password = rs.getString("password");

				Employee employee = new Employee(emp_id, emp_name, salary,
						phone, email, password);

				returnList.add(employee);
			}

		} catch (SQLException e) {
			System.out
					.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}
		return returnList;

	}

}
