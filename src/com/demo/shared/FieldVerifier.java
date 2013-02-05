package com.demo.shared;

/**
 * @author akovacs
 * FieldVerifier validates that the name the user enters is valid.
 */
public class FieldVerifier {
	
	private final static String PASSWORD_VALIDATION_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,32})";


	/**
	 * Verifies that the specified name is valid for our service.
	 * 
	 * @param name the name to validate
	 * @return true if valid, false if invalid
	 */
	public static boolean isValidUsername(String name) {
		if (name == null) {
			return false;
		}
		return name.length() > 3;
	}
	
	
  public static boolean isValidPassword(String password) {

    if (password == null) {
      return false;
    }

//    return password.matches(PASSWORD_VALIDATION_REGEX);
    return password.length() > 4;
  }
}
