package Servlet;

/**
 * Created by Espada on 2014/8/1.
 */

import sql.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/download_excel")
public class download_excel extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException
    { try {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        System.out.println("1111");
        Test temp=new Test();
        temp.create_excel();
        System.out.println("2222");
        out.println("success");

    }
    catch (Exception ex){}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

