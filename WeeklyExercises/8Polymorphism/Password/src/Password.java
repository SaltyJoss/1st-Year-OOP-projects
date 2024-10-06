import java.util.Random;
import java.util.Arrays;

public class Password implements Encryptable{
	
	private String password;
	private boolean encrypted;
	private int shift;
	private Random generator;
	
	public Password(String psswrd) {
		password = psswrd;
		encrypted = false;
		generator = new Random();
		
	}
	
	public void Encrypt() {
		
		if (!encrypted) {
			String masked = "";
	         char ch;
	         for (int index = 0; index < password.length(); index++) {
	        	 	ch = (char)(password.charAt(index));
					masked = ch + masked;
				}
			password = masked;
	        encrypted = true;

		}
	}
	
	public String Decrypt() {
		if (encrypted) {
	         String unmasked = "";
	         char ch;
	         for (int index = 0; index < password.length(); index++) {
	        	 	ch = (char)(password.charAt(index));
					unmasked = ch + unmasked;
				}
	         password = unmasked;
	         encrypted = false;
	    }
	    return password;
    
	}
	
	public boolean isEncrypted() {
		
		return encrypted;
	}
	
	public String toString() {
		return password;
	}
	
}