package org.entity;

public class Book {
      private String bookName;
      private String id;
      private int num;
      private String author;
      private  String publish;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public Book(String bookName, String id, int num, String author, String publish) {
		super();
		this.bookName = bookName;
		this.id = id;
		this.num = num;
		this.author = author;
		this.publish = publish;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", id=" + id + ", num=" + num + ", author=" + author + ", publish="
				+ publish + "]";
	}
	
	
	
}
