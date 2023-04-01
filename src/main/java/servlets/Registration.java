package servlets;

//import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databases.DbConnection;

//@WebServlet("/registration")
public class Registration extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String passsword = request.getParameter("password");
		String image = request.getParameter("image");
		System.out.print(name+email);
		
		DbConnection con = new DbConnection();
		con.registerUser(name, email, passsword, image);
	}
}
