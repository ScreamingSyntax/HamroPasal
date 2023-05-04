package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DbConnection;

public class Registration extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String pass2 = request.getParameter("confirm-password");
		String image = request.getParameter("image");
		if(image.equals("")) {
			image = "profile-eg.png";
		}
		System.out.print("Image is "+ image);
		
		DbConnection con = new DbConnection();
		ResultSet data = con.checkAvailability(email);
		
		try {
			if(!data.next()) {
				if(password.equals(pass2)) {
					con.registerUser(name, email, password, image);	
					try {
						response.sendRedirect("index.jsp");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
//				try {
//					response.sendRedirect("View/Register.jsp");
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
					RequestDispatcher rd = request.getRequestDispatcher("/View/Register.jsp");
					request.setAttribute("passMsg", "Please enter same password in both field.");
					try {
						rd.forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("/View/Register.jsp");
				request.setAttribute("emailMsg", "'"+email+"'"+" is already registered");
				try {
					rd.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
