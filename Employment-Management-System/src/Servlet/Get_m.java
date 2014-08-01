package Servlet;

/**
 * Created by Espada on 2014/8/1.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/Get_m")
public class Get_m extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException
    { try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            String[] dep=request.getParameterValues("department");
            String manager="";
        for (int i=0;i<dep.length;i++){
            switch(dep[i]){
                case("11111"):manager=manager+" A";break;
                case("21111"):manager=manager+" B";break;
                case("31111"):manager=manager+" C";break;
                case("41111"):manager=manager+" D";break;
            }
        }
        out.println(manager);

    }
        catch (Exception ex){}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

