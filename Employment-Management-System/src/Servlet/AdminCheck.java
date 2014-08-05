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
    Manager man_temp;
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
				rs1=st1.executeQuery("select * from employee where emp_id in (select man_id from manager where emp_id="+temp_e.getEmp_id()+")");
				while(rs1.next()){
					man_temp=new Manager();
					man_temp.setEmail(rs1.getString("email"));
					man_temp.setEmp_id(Integer.parseInt(rs1.getString("emp_id")));
					man_temp.setName(rs1.getString("emp_name"));
					man_temp.setPhone(Integer.parseInt(rs1.getString("phone")));
					temp_e.addManager(man_temp);					
				}
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
				rs1=st1.executeQuery("select * from employee where emp_id in (select emp_id from manager where man_id="+temp_m.getEmp_id()+")");
				while(rs1.next()){
					Employee emp_t=new Employee();
					emp_t.setEmail(rs1.getString("email"));
					emp_t.setEmp_id(Integer.parseInt(rs1.getString("emp_id")));
					emp_t.setName(rs1.getString("emp_name"));
					emp_t.setPhone(Integer.parseInt(rs1.getString("phone")));
					emp_t.setSalary(Float.parseFloat(rs1.getString("salary")));
					temp_m.addEmployee(emp_t);
				}
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
