package servlets;

import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databases.StudentDao;
import validation.EmailValidation;
import validation.FullNameValidation;
import validation.PasswordValidation;
@WebServlet(urlPatterns = {"/registration"},name = "registration")

public class Registration extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public boolean checkPassword(String password, String password2) {
		if(password.equals(password2)) {
			return true;
		}
		else {
			return false;
		}
	}
	public void service(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");
		boolean checkPassword = checkPassword(password, password2);
		System.out.println(name+" "+email+" "+password);
		EmailValidation ev = new EmailValidation();
		String checkMailNull = ev.checkNull(email);
		String checkMailFormat = ev.checkEmail(email);
		PasswordValidation pv = new PasswordValidation();
		String passLength = pv.length(password);
		String checkNumberInPass = pv.checkNumber(password);
		String checkSpecialCharacters = pv.checkSpecialCharacters(password);
		String checkUpperCase = pv.checkSpecialCharacters(password);
		FullNameValidation fv = new FullNameValidation();
		String numbersInName = fv.nameLettersNumbers(name);
		String fullName = fv.validFullName(name);
		StudentDao sd = new StudentDao();
		try {
			ResultSet rs= sd.register(name, email, password);
			while(rs.next()){
				System.out.println("");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// TODO Auto-generated catch block
	}
	
}	
