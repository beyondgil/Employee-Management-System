package Servlet;
import sql.*;
import datastructure.Employee;

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

import datastructure.*;
/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	Connection cn;
	Statement st;
	ResultSet rs;
	boolean flag_e,flag_m;
	Employee emp;
	Manager man;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
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
		flag_e=false;
		flag_m=false;
		cn=new DatabaseConnection().getConnection();
		String user=request.getParameter("username");
		String password=request.getParameter("password");
		try{
			st=cn.createStatement();
			rs=st.executeQuery("select * from employee where emp_name = '"+user+"'");
			if(rs.next()){
			emp=new Employee();
			emp.setEmail(rs.getString("email"));
			emp.setEmp_id(Integer.parseInt(rs.getString("emp_id")));
			emp.setName(rs.getString("emp_name"));
			emp.setPhone(Integer.parseInt(rs.getString("phone")));
			emp.setSalary(Float.parseFloat(rs.getString("salary")));
			String passwordcheck=rs.getString("password").toString();
			if (passwordcheck.equals(password)) {flag_e=true;
				if(emp.getEmp_id()>70000) {flag_m=true;
				man=new Manager();
				man.setEmail(emp.getEmail());
				man.setEmp_id(emp.getEmp_id());
				man.setName(emp.getName());
				man.setPhone(emp.getPhone());
				man.setSalary(emp.getSalary());
				rs=st.executeQuery("select * from employee where emp_id in (select emp_id from manager where man_id="+man.getEmp_id()+")");
				while(rs.next()){
					emp=new Employee();
					emp.setEmail(rs.getString("email"));
					emp.setEmp_id(Integer.parseInt(rs.getString("emp_id")));
					emp.setName(rs.getString("emp_name"));
					emp.setPhone(Integer.parseInt(rs.getString("phone")));
					emp.setSalary(Float.parseFloat(rs.getString("salary")));
					man.addEmployee(emp);
				}
				rs=st.executeQuery("select dep_name from department where dep_id =( select dep_id from emp_dep where emp_id="+man.getEmp_id()+")");
				if(rs.next()) man.setDepartment(rs.getString("dep_name"));
				
				}
				else{
					rs=st.executeQuery("select * from employee where emp_id in (select man_id from manager where emp_id="+emp.getEmp_id()+")");
					while(rs.next()){
						man=new Manager();
						man.setEmail(rs.getString("email"));
						man.setEmp_id(Integer.parseInt(rs.getString("emp_id")));
						man.setName(rs.getString("emp_name"));
						man.setPhone(Integer.parseInt(rs.getString("phone")));
						emp.addManager(man);					
					}
					rs=st.executeQuery("select dep_name from department where dep_id in (select dep_id from emp_dep where emp_id="+emp.getEmp_id()+")");
					while(rs.next()){
						String d=rs.getString("dep_name");
						emp.addDepartment(d);
					}
				}
			}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(flag_m){
			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/m_info.jsp");
			 request.setAttribute("man", man);
	         dispatcher.forward(request, response);

		}
		else if(flag_e) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Employee.jsp");
            request.setAttribute("emp", emp);
            dispatcher.forward(request, response);
		}else{
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
            dispatcher.forward(request, response);

		}
	}

}
