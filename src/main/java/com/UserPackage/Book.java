package com.UserPackage;

public class Book {
	
	private String bookName;
	private String dateBorrowed;
	private String returnDate;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getDateBorrowed() {
		return dateBorrowed;
	}
	public void setDateBorrowed(String dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", dateBorrowed=" + dateBorrowed + ", returnDate=" + returnDate + "]";
	}
	
}
