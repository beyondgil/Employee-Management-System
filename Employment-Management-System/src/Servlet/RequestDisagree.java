package Servlet;

import datastructure.Request;
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
 * Servlet implementation class RequestDisgree
 */
@WebServlet("/RequestDisagree")
public class RequestDisagree extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection cn;
	Statement st;
	ResultSet rs;
	int i=0,num=0;
    HttpSession session;
    ArrayList<Request> req=new ArrayList<Request>();
    /**
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public RequestDisagree() {
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
		 req=(ArrayList<Request>)session.getAttribute("Request");
		i=Integer.parseInt(request.getParameter("temd"));
		num=Integer.parseInt(request.getParameter("num"));
		cn=new DatabaseConnection().getConnection();
		try{
			st=cn.createStatement();
			st.executeUpdate("delete from request where emp_id ="+i);
			req.remove(num);
		}catch(Exception e){
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin_request.jsp");
		dispatcher.forward(request, response);
	}
	
}
