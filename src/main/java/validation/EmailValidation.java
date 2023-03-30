package validation;
import java.util.regex.Pattern;

public class EmailValidation {
	public String checkNull(String email){
	        if(email.isEmpty()){
	            return "Email cannot be empty";
	        }
	        else{
	            return null;
	        }
	    }
	 public String checkEmail(String email){
	        String regex ="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	        if(Pattern.matches(regex, email)){
	            return null;
	        }
	        else{
	            return "Enter Valid Mail";
	        }

	    }
}
