
public class Driver {
	
	public static void main(String[] args) {
	    
	    Password locked = new Password("Jossie27!");
	    Secret hush = new Secret("My name is Joss and i like coding");
	    System.out.println(locked);

	    locked.Encrypt();
	    System.out.println(locked);

	    locked.Decrypt();
	    System.out.println(locked);

	}
}
