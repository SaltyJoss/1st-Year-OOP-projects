import java.util.Random;

public class Secret implements Encryptable {
	
	private String message;
	private boolean encrypted;
	private int shift;
	private Random generator;
	
	public Secret(String msg) {
		message = msg;
		encrypted = false;
		generator = new Random();
		shift = generator.nextInt(10) + 5;
		
	}
	
	public void Encrypt() {
		
		if (!encrypted) {
			String masked = "";
			for (int index=0; index < message.length(); index++)
	            masked = masked + (char)(message.charAt(index)+shift);
			
	        message = masked;
	        encrypted = true;

		}
	}
	
	public String Decrypt() {
		if (encrypted) {
	         String unmasked = "";
	         for (int index=0; index < message.length(); index++)
	            unmasked = unmasked + (char)(message.charAt(index)-shift);
	         message = unmasked;
	         encrypted = false;
	    }
	    return message;
	     
	}
	
	public boolean isEncrypted() {
		return encrypted;
	}
	
	public String toString() {
		return message;
	}


}
