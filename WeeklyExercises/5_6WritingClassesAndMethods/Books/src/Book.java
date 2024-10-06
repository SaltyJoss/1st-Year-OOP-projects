
public class Book {
	String title, author, publisher, copyDate;
	
	Book(String title, String author, String publisher, String copyDate){
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.copyDate = copyDate;
		
	}
	String getTitle() {
		return title;
		
	}
	String getAuthor() {
		return author;
		
	}
	String getPublisher() {
		return publisher;
		
	}
	String getCopyDate() {
		return copyDate;
		
	}
	public String toString() {
		return "This book is called " + getTitle() + ", and is written by " + getAuthor() + ".\n"
				+ "Publisher by " + getPublisher() + ".\n"
				+ "Copyrighted on " + getCopyDate() + ".";
	}
}
