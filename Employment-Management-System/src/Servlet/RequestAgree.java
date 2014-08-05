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
import datastructure.Request;

/**
 * Servlet implementation class RequestAgree
 */
@WebServlet("/RequestAgree")
public class RequestAgree extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection cn;
	Statement st;
	ResultSet rs;
	int i=0; 
	String password;
	HttpSession session;
	Request temp=new Request();
	 ArrayList<Request> req=new ArrayList<Request>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestAgree() {
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
		i=Integer.parseInt(request.getParameter("tema"));
		session=request.getSession();
		req=(ArrayList<Request>)session.getAttribute("Request");
		temp=req.get(i);
		cn=new DatabaseConnection().getConnection();	
		try{
			st=cn.createStatement();
			st.executeUpdate("delete from request where emp_id ="+ temp.getEmp_id());
			rs=st.executeQuery("select password from employee where emp_id="+temp.getEmp_id());
			if(rs.next()) password=rs.getString("password");
			st.executeUpdate("delete from emp_dep where emp_id="+temp.getEmp_id());
			st.executeUpdate("delete from manager where emp_id="+temp.getEmp_id());
			st.executeUpdate("delete from employee where emp_id ="+ temp.getEmp_id());
			st.executeUpdate("insert into employee values ("+temp.getEmp_id()+",'"+temp.getName()+"',"+temp.getSalary()+","+temp.getPhone()+",'"+temp.getEmail()+"','"+password+"')");

			int dep=0;
			for(int j=0;j<temp.getDepartment().size();j++){
			switch(temp.getDepartment().get(j)){
			case "Human Resources":dep=11111;
			break;
			case "Technology":dep=21111;
			break;
			case "Marketing":dep=31111;
			break;
			case "Finance":dep=41111;
			break;
			default:break;
			}
			int manid=70000+(dep/10000);
			st.executeUpdate("insert into emp_dep values ("+temp.getEmp_id()+","+dep+")");
			st.executeUpdate("insert into manager values ("+ manid+","+temp.getEmp_id()+")");
			}
			req.remove(i);
		}catch(Exception e){
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin_request.jsp");
		dispatcher.forward(request, response);
	}

}
