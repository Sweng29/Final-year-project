package com.oam.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id",length=11)
	private Integer userId;
	
	@Column(name="email",length=255)
	private String email;
	
	@Column(name="password",length=255)
	private String password;
	
	@Column(name="backup_email",length=255)
	private String backupEmail;
	
	@Column(name="verification_id",length=1)
	private Integer verificationId;
	
	@Column(name="active",length=1)
	private Integer active;
	
	public UserModel(){}
	
	public UserModel(String email, String password, String backupEmail, Integer verificationId, Integer active) {
		super();
		this.email = email;
		this.password = password;
		this.backupEmail = backupEmail;
		this.verificationId = verificationId;
		this.active = active;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBackupEmail() {
		return backupEmail;
	}
	public void setBackupEmail(String backupEmail) {
		this.backupEmail = backupEmail;
	}
	public Integer getVerificationId() {
		return verificationId;
	}
	public void setVerificationId(Integer verificationId) {
		this.verificationId = verificationId;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	
}
