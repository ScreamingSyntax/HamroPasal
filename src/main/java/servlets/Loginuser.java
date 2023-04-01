package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import databases.DbConnection;

public class Loginuser extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		System.out.print("Hello Nepal");
		

		System.out.print(username+password);
		
		DbConnection con = new DbConnection();
		ResultSet resultset=con.loginuser(username, password);
		int count=0;
		if(resultset!=null)
		{
			try {
				while(resultset.next()) {
					count+=1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.print("null");
//			return "";
		}

		System.out.print(count);
//		if(count==0) {
//			
//		}else {
//			
//		}
		
		if(count==0) {
			
			request.setAttribute("errorMessage", "Invalid user or password");
            RequestDispatcher rd = request.getRequestDispatcher("/View/login.jsp");
            rd.forward(request, response); 
			
		}
		else {
			response.setContentType("text/html");

			request.setAttribute("id", username);
//			request.setAttribute("errorMessage", "Invalid user or password");

			RequestDispatcher rd = request.getRequestDispatcher("Profile.jsp");
//			response.sendRedirect("View/Profile.jsp");
//			rd.forward(request, response);
			
		}

		}
		
    	
//    }
	}

