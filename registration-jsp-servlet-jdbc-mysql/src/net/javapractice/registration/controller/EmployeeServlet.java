package net.javapractice.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javapractice.registration.dao.EmployeeDao;
import net.javapractice.registration.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDao empDao = new EmployeeDao(); 

    /**
     * Default constructor. 
     */
    public EmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher rDis = request.getRequestDispatcher("/WEB-INF/views/employeeregister.jsp"); 
		rDis.forward(request, response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		Employee empl = new Employee(); 
		empl.setFirstName(firstName);
		empl.setLastName(lastName);
		empl.setUsername(username);
		empl.setPassword(password);
		empl.setAddress(address);
		empl.setContact(contact); 
		
		try {
			empDao.registerEmployee(empl);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//response.sendRedirect("");
		RequestDispatcher rDis = request.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp"); 
		rDis.forward(request, response);
		
	}

}
