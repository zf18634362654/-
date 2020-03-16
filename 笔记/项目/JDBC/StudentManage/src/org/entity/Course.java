package org.entity;

import java.util.Date;

public class Course {
	private String cno;
	private String cname;
	private String credit;
	private Date startTime;
	private String place;
	private String teacher;
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public Course(String cno, String cname, String credit, Date startTime, String place, String teacher) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.credit = credit;
		this.startTime = startTime;
		this.place = place;
		this.teacher = teacher;
	}
	public Course() {
		super();
	}
	@Override
	public String toString() {
		return "Course [cno=" + cno + ", cname=" + cname + ", credit=" + credit + ", startTime=" + startTime
				+ ", place=" + place + ", teacher=" + teacher + "]";
	}
  
	
	
}
