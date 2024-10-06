import java.util.Scanner;

public class Bookshelf {

	public static void main(String[] args) {
		String title, author, publisher, copyDate;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("What is the title of the book? ");
		title = scan.nextLine();
		
		System.out.print("Who is the book by? ");
		author = scan.nextLine();
		
		System.out.print("Who published the book? ");
		publisher = scan.nextLine();
		
		System.out.print("When was the book copyrighted (D/M/Y)? ");
		copyDate = scan.nextLine();
		
		Book obj = new Book(title, author, publisher, copyDate);
		
		System.out.println("");
		System.out.println(obj);
		
	}

}
