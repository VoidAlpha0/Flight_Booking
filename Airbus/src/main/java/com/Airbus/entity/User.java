package com.Airbus.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "user",schema = "bus")
public class User {
	@Id
	@GeneratedValue(generator = "usergen" ,strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "usergen", sequenceName = "user_seq",initialValue = 1,allocationSize = 1)
	private Integer userId;
	@Column(unique = true, nullable= false)
	private String useremail;
	private String username;
	private String userphonenumber;
	private String userpassword;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserphonenumber() {
		return userphonenumber;
	}
	public void setUserphonenumber(String userphonenumber) {
		this.userphonenumber = userphonenumber;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	
	
}