package ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validadores {

	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String PATTERN_PASS = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,16}$";
	
	public static boolean formatoEmailValido(String email) {
		
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
	public static boolean formatoPassValido(String pass) {
		
		Pattern pattern = Pattern.compile(PATTERN_PASS);
		 
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
        
	}
}
