package Servlet;

import datastructure.Employee;
import datastructure.Manager;
import sql.DatabaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Servlet implementation class AdminEmpAdd
 */
@WebServlet("/AdminEmpAdd")
public class AdminEmpAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection cn;
	Statement st;
	ResultSet rs;
	int i=0; 
	HttpSession session;
	Employee temp=new Employee();
	 ArrayList<Employee> emp=new ArrayList<Employee>();
    /**
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public AdminEmpAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession();
		emp=(ArrayList<Employee>)session.getAttribute("Employee");
		cn=new DatabaseConnection().getConnection();
		String name=request.getParameter("name");
		float salary=Float.parseFloat(request.getParameter("salary"));
		int phone=Integer.parseInt(request.getParameter("phone"));
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String[] department=request.getParameterValues("department");
		int id=10000+emp.size()+1;
		try{
			st=cn.createStatement();
			st.executeUpdate("insert into employee values ("+id+",'"+name+"',"+salary+","+phone+",'"+email+"','"+password+"')");
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
					st.executeUpdate("insert into emp_dep values("+id+","+depid+")");
					st.execute("insert into manager values("+manid+","+id+")");
				}
			
			}
			temp.setEmail(email);
			temp.setEmp_id(id);
			temp.setName(name);
			temp.setPassword(password);
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
