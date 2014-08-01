package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.DatabaseConnection;

/**
 * Servlet implementation class RequestDisgree
 */
@WebServlet("/RequestDisgree")
public class RequestDisagree extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection cn;
	Statement st;
	ResultSet rs;
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
        this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();

                out.println("CANNOT CHANGE");


        }
        catch (Exception ex){}
    }


}
