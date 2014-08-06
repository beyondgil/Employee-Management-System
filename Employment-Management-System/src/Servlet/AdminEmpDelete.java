package Servlet;

import datastructure.Employee;
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
 * Servlet implementation class AdminEmpDelete
 */
@WebServlet("/AdminEmpDelete")
public class AdminEmpDelete extends HttpServlet {
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
    public AdminEmpDelete() {
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
		i=Integer.parseInt(request.getParameter("temED"));
		session=request.getSession();
		emp=(ArrayList<Employee>)session.getAttribute("Employee");
		temp=emp.get(i);
		cn=new DatabaseConnection().getConnection();
		try{
			st=cn.createStatement();
			st.executeUpdate("delete from request where emp_id ="+ temp.getEmp_id());
			st.executeUpdate("delete from emp_dep where emp_id="+temp.getEmp_id());
			st.executeUpdate("delete from manager where emp_id="+temp.getEmp_id());
			st.executeUpdate("delete from employee where emp_id ="+ temp.getEmp_id());
			emp.remove(i);
		}catch(Exception e){
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/employee_list.jsp");
		dispatcher.forward(request, response);
	}

}
