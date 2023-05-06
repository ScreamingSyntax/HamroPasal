package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbConnection {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hamropasal", "root", "");
		return connection;
	}

	public String registerUser(User user) {
		String message;
		try {
			String query = "INSERT INTO users (Name, Email, Password, Image) VALUES (?,?,?,?)";
			Connection connection = getConnection();
			PreparedStatement st = connection.prepareStatement(query);

			st.setString(1, user.getName());
			st.setString(2, user.getEmail());
			st.setString(3, user.getPassword());
			st.setString(4, user.getImagePath());
			int rows = st.executeUpdate();
			if (rows >= 1) {
				message = "Successfully Added";
			} else {
				message = "Something is missing";
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			message = e.getMessage();
		} catch (SQLException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return message;
	}

	public ResultSet checkAvailability(String email) {
		String query = "Select * from users where email = ?";
		ResultSet data = null;
		try {
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			data = st.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public String addProduct(String name,String quantity,String productPrice,String imagePath) {

		String message = null;
		try {
//			String name = product.getProductName();
//			String quantity = product.getProductQuantity();
//			String productPrice = product.getProductPrice();
//			String imagePath = product.getProductImagePath();
			String query = "INSERT INTO products (product_name, product_quantity, product_price) VALUES ('" + name
					+ "','" + quantity + "','" + productPrice + "');";

			Connection connection = getConnection();
			PreparedStatement st;
			st = connection.prepareStatement(query);
			System.out.print(query);
			int rows = st.executeUpdate();
			if (rows >= 1) {
				String findId = "Select max(product_id) from products;";

				st = connection.prepareStatement(findId);

				ResultSet data = st.executeQuery();
				System.out.println("CHeck id");
				while (data.next()) {
					message = (data.getString(1));
				}
			} else {
				message = "Something is missing";
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			message = e.getMessage();
		} catch (SQLException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return message;
	}

	public String updateProdutImagePath(String path, String id) throws ClassNotFoundException, SQLException {
		String updateQuery = "Update products set product_image='" + path + "' where product_id='" + id + "';";
		System.out.println(updateQuery);
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(updateQuery);
		int rows = st.executeUpdate();
		return "Successfully added";
	}
	
	
//	@SuppressWarnings("null")
	public ArrayList<Product> fetchProducts() {
		String query = "Select * from products";
		ResultSet data = null;
		try {
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(query);
			data = st.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("His is fetch");
		ArrayList<Product> product=new ArrayList<>();
		
		try {
			
			while(data.next()) {
				
				String productId=data.getString(1);
				String productName=data.getString(2);
				String productImagePath=data.getString(3);
				String productQuantity=data.getString(4);
				String productPrice=data.getString(5);
				System.out.println(productId);
				System.out.println(productName);
				System.out.println(productQuantity);
				System.out.println(productPrice);
				System.out.println(productImagePath);
				System.out.println();//				
				product.add(new Product(productId, productName, productQuantity, productPrice,productImagePath));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	
	public String deleteParameter(String id) throws SQLException {
		String query="Delete from products where product_id='"+id+"';";
		System.out.print(query);
		try {
//			con = getConnection();
//			PreparedStatement st = con.prepareStatement(query);
//			int rows=st.executeQuery();
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(query);
			int rows = st.executeUpdate();
			
			return "Successfully Deleted";


		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Product fetchOneRow(String id) {
		String query="Select * from products where product_id='"+id+"'";
		ResultSet data = null;
		try {
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(query);
			data = st.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("His is fetch");	
		Product product;
try {
			
			while(data.next()) {
				
				String productId=data.getString(1);
				String productName=data.getString(2);
				String productImagePath=data.getString(3);
				String productQuantity=data.getString(4);
				String productPrice=data.getString(5);
				System.out.print(productId);
				System.out.print(productName);
				System.out.print(productImagePath);
				System.out.print(productQuantity);
				System.out.print(productPrice);
				product=new Product( id, productName,productQuantity,productPrice,productImagePath);
				return  product;

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return null;
	}

}
