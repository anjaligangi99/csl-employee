package com.scb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
	private Long userId;
    
    @Column(name="userName")
    private String userName;
    
    @Column(name = "dob")
    private Date dob;
    
    @Column(name = "salary")
    private Float salary;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public User(Long userId, String userName, Date dob, Float salary) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.dob = dob;
		this.salary = salary;
	}

	public User() {
		super();
	}
    
    
}
