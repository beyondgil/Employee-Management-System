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
import datastructure.*;
/**
 * Servlet implementation class AdminCheck
 */
@WebServlet("/AdminCheck")
public class AdminCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ArrayList<Employee> emp=new ArrayList<Employee>();
    ArrayList<Request> req=new ArrayList<Request>();
    ArrayList<Manager> man=new ArrayList<Manager>();
    HttpSession session;
    Connection cn;
    Statement st,st1;
    ResultSet rs,rs1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCheck() {
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
		req.clear();
		man.clear();
		emp.clear();
		if(request.getParameter("username").equals("admin")){
		cn=new DatabaseConnection().getConnection();
		try{
			st=cn.createStatement();
			st1=cn.createStatement();
			rs=st.executeQuery("select * from request");
			while(rs.next()){
				Request temp=new Request();
				temp.setEmail(rs.getString("email"));
				temp.setEmp_id(Integer.parseInt(rs.getString("emp_id")));
				temp.setName(rs.getString("emp_name"));
				temp.setPhone(Integer.parseInt(rs.getString("phone")));
				temp.setSalary(Float.parseFloat(rs.getString("salary")));
				String[] department=rs.getString("departments").split(",");
				for(int i=0;i<department.length;i++){
					temp.addDepartment(department[i]);
				}
				req.add(temp);
			}
			rs=st.executeQuery("select * from employee");
			while(rs.next()){
				int flag=Integer.parseInt(rs.getString("emp_id"));
				if(flag<70000){
				Employee temp_e=new Employee();
				temp_e.setEmail(rs.getString("email"));
				temp_e.setEmp_id(Integer.parseInt(rs.getString("emp_id")));
				temp_e.setName(rs.getString("emp_name"));
				temp_e.setPhone(Integer.parseInt(rs.getString("phone")));
				temp_e.setSalary(Float.parseFloat(rs.getString("salary")));
				rs1=st1.executeQuery("select dep_name from department where dep_id in (select dep_id from emp_dep where emp_id="+temp_e.getEmp_id()+")");
				while(rs1.next()){
					String d=rs1.getString("dep_name");
					temp_e.addDepartment(d);
				}
				emp.add(temp_e);
				}else{
				Manager temp_m=new Manager();
				temp_m.setEmail(rs.getString("email"));
				temp_m.setEmp_id(Integer.parseInt(rs.getString("emp_id")));
				temp_m.setName(rs.getString("emp_name"));
				temp_m.setPhone(Integer.parseInt(rs.getString("phone")));
				temp_m.setSalary(Float.parseFloat(rs.getString("salary")));
				rs1=st1.executeQuery("select dep_name from department where dep_id =( select dep_id from emp_dep where emp_id="+temp_m.getEmp_id()+")");
				if(rs1.next()) temp_m.setDepartment(rs1.getString("dep_name"));
				man.add(temp_m);
				}
			}
			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin_request.jsp");
			 session=request.getSession();
			 session.setAttribute("Request",req);
			 session.setAttribute("Employee",emp);
			 session.setAttribute("Manager",man);
	         dispatcher.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	}

}
