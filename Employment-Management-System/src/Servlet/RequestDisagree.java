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

import datastructure.Request;
import sql.DatabaseConnection;

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
     * @see HttpServlet#HttpServlet()
     */
    public RequestDisagree() {
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
