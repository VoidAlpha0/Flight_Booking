package com.Airbus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admins",schema = "bus")
@Data @NoArgsConstructor @AllArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(generator = "admingen" ,strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "admingen", sequenceName = "admin_seq",initialValue = 1,allocationSize = 1)
	private Integer id;
	@Column(nullable = false, unique =true)
	private String adminname;
	@Column(nullable = false)
	private String adminpassword;
	@Column(unique = true, nullable = false)
	private String adminemail;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	public String getAdminemail() {
		return adminemail;
	}
	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}
}