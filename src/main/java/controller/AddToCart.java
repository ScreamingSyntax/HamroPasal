package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import model.DbConnection;
import model.Product;
@WebServlet("/addCart")
public class AddToCart extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Product> cart = new ArrayList<Product>();
//	public void doGet(HttpServletRequest req, HttpServletResponse res) {
//		System.out.println("One");
//		String imagePath = req.getParameter("imagePath");
//		DbConnection dc = new DbConnection();
//		ResultSet rd =dc.fetchProductByImage(imagePath);
//		try {
//			while(rd.next()) {
//				System.out.println(rd.getString(1));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		RequestDispatcher rd = req.getRequestDispatcher(imagePath);
//	}
	public void service( HttpServletRequest req, HttpServletResponse res) {
		String imagePath = req.getParameter("imagePath");
		String email = req.getParameter("email");
		System.out.println("User Email is "+ email);
		DbConnection dc = new DbConnection();
		ResultSet data =dc.fetchProductByImage(imagePath);
		String productImagePath = "";
		try {
			while(data.next()) {
					String productId=data.getString(1);
					String productName=data.getString(2);
					productImagePath=data.getString(3);
					String productQuantity=data.getString(4);
					String productPrice=data.getString(5);
					cart.add(new Product(productId, productName, productImagePath, productQuantity, productPrice));
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
