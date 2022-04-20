package com.cg.onlineeyecare.admin.dto;
import org.springframework.stereotype.Component;
@Component
public class Admin {
	private int adminId;
	private String adminUsername;
	private String adminPassword;
	//getters and setters
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}	
}
