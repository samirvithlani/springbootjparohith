package com.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentBean {

	@Id
	@GeneratedValue
	private int sId;

	private String sName;
	private String sEmail;
	private String sPassword;
	private int sAGe;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CourseBean> courses;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public int getsAGe() {
		return sAGe;
	}
	public void setsAGe(int sAGe) {
		this.sAGe = sAGe;
	}
	public List<CourseBean> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseBean> courses) {
		this.courses = courses;
	}
	
	
	
}
