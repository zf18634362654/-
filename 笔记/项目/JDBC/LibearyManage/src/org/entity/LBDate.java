package org.entity;

import java.util.Date;

public class LBDate {
	 private  int sno;
	 private int brid;
	 private  int bookId;
	 private  String name;
	 private  String bookName;
      
	 private  Date borrowDate;
	 private   Date lendDate;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getBrid() {
		return brid;
	}
	public void setBrid(int brid) {
		this.brid = brid;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookid) {
		this.bookId = bookid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getLendDate() {
		return lendDate;
	}
	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}
	public LBDate(int sno, int brid, int bookid, String bookName, Date borrowDate, Date lendDate,String name) {
		super();
		this.name=name;
		this.sno = sno;
		this.brid = brid;
		this.bookId = bookid;
		this.bookName = bookName;
		this.borrowDate = borrowDate;
		this.lendDate = lendDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LBDate() {
		super();
	}
	@Override
	public String toString() {
		return "LBDate [sno=" + sno + ", brid=" + brid + ", bookid=" + bookId + ", bookName=" + bookName
				+ ", borrowDate=" + borrowDate + ", lendDate=" + lendDate + "]";
	}
	
	
	
}
