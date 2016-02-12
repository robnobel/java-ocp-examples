package collections.sorting;

public class Book implements Comparable<Book>{     //typed declaration !
	int isbn;
	String title;
	
	public Book(int isbn, String title){
		this.isbn = isbn;
		this.title = title;
	}
	
	@Override
	public int compareTo(Book book) {   //beware, should take Book as param type
		return title.compareTo(book.getTitle());
	}
		
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	
}
