package org.entity;

public class Grade {
     private int English;
     private int Chinese;
     private int Math;
     private int c;
     private int java;
     private int sno;
     private  String sname;
     private int sum;
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getEnglish() {
		return English;
	}
	public void setEnglish(int english) {
		English = english;
	}
	public int getChinese() {
		return Chinese;
	}
	public void setChinese(int chinese) {
		Chinese = chinese;
	}
	public int getMath() {
		return Math;
	}
	public void setMath(int math) {
		Math = math;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Grade(int english, int chinese, int math, int c, int java, int sno, String sname,int sum) {
		super();
		this.sum=sum;
		this.English = english;
		Chinese = chinese;
		Math = math;
		this.c = c;
		this.java = java;
		this.sno = sno;
		this.sname = sname;
	}
	public Grade() {
		super();
	}
     
     
     
     
     
     
     
	
	
	
}
