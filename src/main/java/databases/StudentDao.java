package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
	public Connection connection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/lab6";
		String username = "root";
		String password ="";
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.print("Connection Succedd");
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
		
	}
	public ResultSet register(String name, String email, String password) throws SQLException, ClassNotFoundException {
		Connection con = connection();
		String query = "Insert into users(name,email,password) values(?,?,?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, name);
		st.setString(2, email);
		st.setString(3, password);
		ResultSet rs = st.executeQuery();
		return rs;
	}
}
