package validation;
import java.util.regex.Pattern;
public class FullNameValidation {
	    public String nameLettersNumbers(String name){
	        String regex=   "[0-9]+[\\.]?[0-9]*";
	        // else{
	        //     return false;
	        // }
	        for(int i = 0; i<name.length();i++){
	        if(Pattern.matches(regex, Character.toString(name.charAt(i)))){
	            return "Name cannot contain numbers or special Characters";
	        }
	        }
	        return null;
	    }
	   public String validFullName(String name){
	        String[] fullName = name.split(" ");
	        if(fullName.length <=1){
	            return "Enter ForeName and Surname";
	        }
	        if(fullName.length == 2 ){
	            if(fullName[0].length() <3){
	                return "Forename too short";
	            }
	            if(fullName[1].length()<3){
	                return "Surname too Short";
	            }
	            return null;
	        }
	        else{
	            return "Invalid Name";
	        }
	    }
}
