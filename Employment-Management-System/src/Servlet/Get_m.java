package Servlet;

/**
 * Created by Espada on 2014/8/1.
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


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
                case("11111"):manager=manager+" Luaura   ";break;
                case("21111"):manager=manager+" Anne  ";break;
                case("31111"):manager=manager+" Cassie  ";break;
                case("41111"):manager=manager+" Charlotte  ";break;
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

