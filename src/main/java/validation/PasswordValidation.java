package validation;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class PasswordValidation{
	public String length(String password1){
	        if(password1.length() > 7){
	            return null;
	        }
	        else{
	            return "Please add length greater than 7";
	        }
	    }
	public String checkNumber(String password1){
	        String regex = "[0-9]+[\\.]?[0-9]*";
	        // Array strings[];
	        // Array numbers[];
	        ArrayList<String> strings = new ArrayList<>();
	        ArrayList<String> numbers = new ArrayList<>(); 
	        for(int i = 0; i < password1.length(); i++){
	        String eachCharacter = Character.toString(password1.charAt(i));
	        //    System.out.print( Pattern.matches(regex, eachCharacter));
	        if(Pattern.matches(regex, eachCharacter)){
	            numbers.add(eachCharacter);
	          }
	        if(eachCharacter.equals(eachCharacter.toString())){
	            strings.add(eachCharacter);
	        }
	        }
	        if(numbers.isEmpty()){
	            return "Please Enter a Number";
	        }
	        else{
	            return null;
	        }

	    }
	  public String checkSpecialCharacters(String password1){
	        String specialRegex = "[$&+,:;=?@#|'<>.^*()%!-]";
	        ArrayList<String> specialCharacter = new ArrayList<>();
	        for(int i = 0; i < password1.length(); i++){
	        String eachCharacter = Character.toString(password1.charAt(i));
	        if(Pattern.matches(specialRegex, eachCharacter)){
	            specialCharacter.add(eachCharacter);
	        }
	    }
	        if(specialCharacter.isEmpty()){
	            return "Please Enter a Special Character";
	        }
	        else{
	           return null;
	        }

	    }
	 public String checkUpperCase(String password1){
	        for(int i = 0; i < password1.length(); i++  ){
	        String eachCharacter = Character.toString(password1.charAt(i));
	            // System.out.println(stringList.charAt(i));
	            if(eachCharacter.equals(eachCharacter.toUpperCase())){
	                return null;
	            }
	        // if(eachCharacter.equals())
	        }
	        return "Please Enter an Uppercase";
	        
	    }
}