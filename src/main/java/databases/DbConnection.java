package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HamroPasal","root","");
		
		return connection;
	}
	
	public void registerUser(String name, String email, String password, String image) {
		String query = "INSERT INTO users (Name, Email, Password, Image) VALUES (?,?,?,?)";
		
		try {
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);
			st.setString(2, email);
			st.setString(3, password);
			st.setString(4, image);
			
			st.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
