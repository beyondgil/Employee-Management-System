package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.EmployeeService;
import domain.Employee;

public class displayAllEmployeesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeService service = new EmployeeService();
		List<Employee> allEmployees = service.getAllEmployees();

		request.setAttribute("allEmployees", allEmployees);

		ServletContext context = getServletContext();
		RequestDispatcher dispatch = context
				.getRequestDispatcher("/JSP/displayAllEmployees.jsp");
		dispatch.forward(request, response);
	}

}
