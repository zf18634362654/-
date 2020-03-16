package org.entity;

public class Loginer {
     private String id;
     private String pwd;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Loginer(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	public Loginer() {
		super();
	}
     
	 
}
