/*package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {

	private Integer Id;
	private String userName;
	private String password;
	private  String role;
	BCryptPasswordEncoder generator=new BCryptPasswordEncoder();
	public User() {
		super();
	}
	public User(Integer id, String userName, String password, String role, BCryptPasswordEncoder generator) {
		super();
		Id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.generator = generator;
	}
	@javax.persistence.Id
	@GeneratedValue
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = generator.encode(password);
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [Id=" + Id + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ "]";
	}

	
	
}
*/