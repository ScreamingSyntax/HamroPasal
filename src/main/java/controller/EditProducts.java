package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DbConnection;
import model.Product;

/**
 * Servlet implementation class EditProducts
 */
@WebServlet("/editproducts")
public class EditProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		DbConnection conn=new DbConnection();
		Product product= conn.fetchOneRow(id);
		
		request.setAttribute("productDetails",product);
		RequestDispatcher rd = request.getRequestDispatcher("View/EditProducts.jsp");
		rd.forward(request, response);
		
		doGet(request, response);
	}

}
