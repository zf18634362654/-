package org.entity;

public class Student  extends Loginer{
    private int sno;
    private String sname;
    private String id;
    private String sex;
    private String pwd;
    private String phone;
    private String birthPlace;
	public int  getSno() {
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public Student(int sno, String sname, String id, String sex, String pwd, String phone, String birthPlace) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.id = id;
		this.sex = sex;
		this.pwd = pwd;
		this.phone = phone;
		this.birthPlace = birthPlace;
	}
	public Student(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	public Student() {
		super();
	}

	public Student( int sno, String sname, String sex, String phone, String birthPlace) {
		
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.phone = phone;
		this.birthPlace = birthPlace;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", id=" + id + ", sex=" + sex + ", pwd=" + pwd + ", phone="
				+ phone + ", birthPlace=" + birthPlace + "]";
	}

	public Student( int sno, String sname) {
		super();
		this.sno = sno;
		this.sname = sname;
	}

	
    
	
	
	
	
}
