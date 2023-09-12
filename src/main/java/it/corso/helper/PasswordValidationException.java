package it.corso.helper;

public class PasswordValidationException extends RuntimeException{
	private static final long serialVersionUID = 5054532917036415626L;
	// è un numero che eclipse ti invita a mettere 
	private final String message = "Invalid Password";
	
	public String getMessage() {
		return message;
	}
	
	
}
