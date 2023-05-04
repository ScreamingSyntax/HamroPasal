package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
