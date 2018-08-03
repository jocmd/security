package com.power.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;
import com.power.validator.MyConstraint;

import io.swagger.annotations.ApiModelProperty;

public class User {
	
	public interface UserSimpleView{};
	public interface UserDetailsView extends UserSimpleView{};
	
    @NotEmpty(message="用户名不能为空")
	private String username;
    @MyConstraint(message = "测试注解")
    @ApiModelProperty(value="密码")
	private String password;
    @ApiModelProperty(value="年龄")
	private String age;
	@JsonView(UserSimpleView.class)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JsonView(UserDetailsView.class)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@JsonView(UserSimpleView.class)
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String age) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + "]";
	}
	
}
