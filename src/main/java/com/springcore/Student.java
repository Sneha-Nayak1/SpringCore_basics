package com.springcore;

public class Student {
	
	private int studentId;
	private String studentName;
	private String studentAddress;
	
	public int getStudentId() {
		System.out.println("Getter id");
		return studentId;
	}
	public void setStudentId(int studentId) {
		System.out.println("Setter id");
		this.studentId = studentId;
	}
	public String getStudentName() {
		System.out.println("Getter name");
		return studentName;
	}
	public void setStudentName(String studentName) {
		System.out.println("Setter name");
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		System.out.println("Getter address");
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		System.out.println("Setter address");
		this.studentAddress = studentAddress;
	}
	
	public Student(int studentId, String studentName, String studentAddress) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ "]";
	}
	
	
	
	

}
