package nuc.bean;

public class zfBook {
   private String publisher;
   private String title;
   private String author;
   private int   bookid;
   public zfBook(String publisher, String title, int zfbookid,String author) {
		super();
		this.publisher = publisher;
		this.title = title;
		this.bookid = zfbookid;
		this.author=author;
				
	}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
@Override
public String toString() {
	return "zfBook [publisher=" + publisher + ", title=" + title + ", author=" + author + ", bookid=" + bookid + "]";
}
	
	
	
}
