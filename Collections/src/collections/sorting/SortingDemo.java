package collections.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingDemo {

	public static void main(String[] args) {
		SortingDemo sortDemo = new SortingDemo();
		ArrayList<Book> list = sortDemo.initBookList();
		
		//use comparable : Book implements Comparable > limitation : tight coupling + you can only use 1 Comparable impl. 
		Collections.sort(list);
		showMeTheBooks(list);
		
		//use comparator to sort desc. by title > now you can use many Comparator implementations
		Collections.sort(list, sortDemo.new BookDescComparator());
		showMeTheBooks(list);
		
		//use comparator to sort asc. by title > now you can use many Comparator implementations
		Collections.sort(list, sortDemo.new BookAscComparator());
		showMeTheBooks(list);
	}
	
	private ArrayList<Book> initBookList(){
		ArrayList<Book> bookList = new ArrayList<>();
		bookList.add(new Book(1, "Ben je betoeterd"));
		bookList.add(new Book(2, "Altijd is Kortjakje ziek"));
		bookList.add(new Book(1, "Crackerjacks"));
		return bookList;
	}
	
	private static void showMeTheBooks(ArrayList<Book> list){
		for(Book b:list){
			System.out.println(b.getTitle());
		}
		System.out.println();
	}
	
	/**
	 * comparator sorting books desc by title
	 */
	private class BookDescComparator implements Comparator<Book>{
		public int compare(Book book1, Book book2){
			return (book2.getTitle()).compareTo(book1.getTitle());
		}
	}
	
	/**
	 * comparator sorting books desc by title
	 */
	private class BookAscComparator implements Comparator<Book>{
		public int compare(Book book1, Book book2){
			return (book1.getTitle()).compareTo(book2.getTitle());
		}
	}

}
