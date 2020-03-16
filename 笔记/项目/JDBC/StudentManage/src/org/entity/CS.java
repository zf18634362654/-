package org.entity;

public class CS {
     private  int sno;
     private String cno;
	public CS(int sno, String cno) {
		super();
		this.sno = sno;
		this.cno = cno;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	@Override
	public String toString() {
		return "CS [sno=" + sno + ", cno=" + cno + "]";
	}
     
	
	
	
}
