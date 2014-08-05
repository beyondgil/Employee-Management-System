package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sql.DatabaseConnection;
import datastructure.Employee;
import datastructure.Manager;

/**
 * Servlet implementation class AdminEmpUpdate
 */
@WebServlet("/AdminEmpUpdate")
public class AdminEmpUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection cn;
	Statement st;
	ResultSet rs;
	int i=0; 
	HttpSession session;
	Employee temp=new Employee();
	 ArrayList<Employee> emp=new ArrayList<Employee>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEmpUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		i=Integer.parseInt(request.getParameter("no"));
		session=request.getSession();
		emp=(ArrayList<Employee>)session.getAttribute("Employee");
		temp=emp.get(i);
		emp.remove(i);
		temp.getDepartment().clear();
		temp.getManager().clear();
		cn=new DatabaseConnection().getConnection();
		String name=request.getParameter("name");
		float salary=Float.parseFloat(request.getParameter("salary"));
		int phone=Integer.parseInt(request.getParameter("phone"));
		String email=request.getParameter("email");
		String[] department=request.getParameterValues("department");
		try{
			st=cn.createStatement();
			st.executeUpdate("delete from emp_dep where emp_id="+temp.getEmp_id());
			st.executeUpdate("delete from manager where emp_id="+temp.getEmp_id());
			st.executeUpdate("delete from employee where emp_id ="+ temp.getEmp_id());
			st.executeUpdate("insert into employee values ("+temp.getEmp_id()+",'"+name+"',"+salary+","+phone+",'"+email+"','"+temp.getPassword()+"')");
			for(int i=0;i<department.length;i++){
				int depid=Integer.parseInt(department[i]);
				rs=st.executeQuery("select * from department where dep_id="+depid);
				if(rs.next()) {	int manid=Integer.parseInt(rs.getString("man_id"));
					temp.addDepartment(rs.getString("dep_name"));
					rs=st.executeQuery("select * from employee where emp_id="+manid);
					Manager man=new Manager();
					if(rs.next())man.setName(rs.getString("emp_name"));
					System.out.println(man.getName());
					temp.addManager(man);
					st.executeUpdate("insert into emp_dep values("+temp.getEmp_id()+","+depid+")");
					st.execute("insert into manager values("+manid+","+temp.getEmp_id()+")");
				}
			
			}
			temp.setEmail(email);
			temp.setName(name);
			temp.setPhone(phone);
			temp.setSalary(salary);
			emp.add(temp);
		}catch(Exception e){
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/employee_list.jsp");
		dispatcher.forward(request, response);
	}

}
