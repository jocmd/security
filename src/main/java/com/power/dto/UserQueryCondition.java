package com.power.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserQueryCondition {
	
    @ApiModelProperty(value="用户名")
	private String username;
    @ApiModelProperty(value="密码")
	private String password;
    @ApiModelProperty(value="年龄")
	private String age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + "]";
	}
	
}
