import java.util.Random;
import java.util.Scanner;

public class PinEncryption {

	public static void main(String[] args) {
		int pin, num1, num2;
		String convert, num1Conv, num2Conv, encrypt;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Choose a pin number: ");
		pin = scan.nextInt();
		scan.close();
		
		convert = Integer.toHexString(pin);
		Random gen = new Random();
		
		num1 = gen.nextInt(1000, 65536);
		num1Conv = Integer.toHexString(num1);
		num2 = gen.nextInt(1000, 65536);
		num2Conv = Integer.toHexString(num2);
		
		encrypt = num1Conv + convert + num2Conv;
		
		System.out.print("Your encrypted pin number is " + encrypt + ".");

	}

}
