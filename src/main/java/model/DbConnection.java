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
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HamroPasal","root","");
		return connection;
	}
	
	public String registerUser(User user) {
		String message;
		try {
			String query="INSERT INTO users (Name, Email, Password, Image) VALUES (?,?,?,?)";
			Connection connection=getConnection();
			PreparedStatement st=connection.prepareStatement(query);
			
			st.setString(1, user.getName());
			st.setString(2, user.getEmail());
			st.setString(3, user.getPassword());
			st.setString(4, user.getImagePath());
			int rows = st.executeUpdate();
			if(rows>=1) {
				message = "Successfully Added";
			}
			else {
				message = "Something is missing";
			}
			connection.close();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			message = e.getMessage();
		}
		catch(SQLException e) {
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
	
	public String checkLoginDetails(String email, String password) {
		String userImage= "";
		try {
			Connection con = getConnection();
			String query = "Select * from users where email =? and password=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet table = st.executeQuery();
			while(table.next()) {
				userImage = table.getString(5);
			}
			if(userImage!="") {
				System.out.println(userImage);
				return userImage;
			}
			else {
				return null;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet adminLogin(String email, String password) {
		try {
			Connection con = getConnection();
			String query = "Select * from admin where email =? and password=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet table = st.executeQuery();

			if(table.next()) {
				return table;
			}
			else {
				return null;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ResultSet getUserData(String email) 
	{
		try {
			Connection con = getConnection();
			String query = "Select * from users where email=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,email);
			ResultSet table = st.executeQuery();
			if(table.next()) {
				return table;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<User> getUserDetails(String email) {
		ArrayList<User> users = new ArrayList<>();
	    try {
	        Connection con = getConnection();
	        String query = "SELECT * FROM users WHERE email=?";
	        PreparedStatement st = con.prepareStatement(query);
	        st.setString(1, email);
	        ResultSet table = st.executeQuery();
	        while (table.next()) {
	        	String name = table.getString("Name");
	            String userEmail = table.getString("Email");
	            String userPassword = table.getString("Password");
	            String image = table.getString("Image");
	            User user = new User(name,userEmail, userPassword, image);
	            users.add(user);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    return users;
	}

}
