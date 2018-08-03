package com.power.web.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.power.dto.User;
import com.power.dto.UserQueryCondition;
import com.power.exception.UserNotExistException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.power.dto.User.UserDetailsView;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@GetMapping
	@JsonView(User.UserSimpleView.class)
	@ApiOperation(value="用户查询服务queryUserList")
	public List<User> queryUserList(UserQueryCondition condition,@PageableDefault(page=2,size=10,sort="age,asc") Pageable pageable){
		System.out.println(condition);
		System.out.println(pageable.toString());
		List<User> list = new ArrayList<User>();
		User user1 = new User("小明", "123", "12");
		User user2 = new User("小明", "123", "12");
		User user3 = new User("小明", "123", "12");
		list.add(user3);
		list.add(user2);
		list.add(user1);
		return list;
	}
	
	@GetMapping("/{id:\\d+}")
	@JsonView(User.UserDetailsView.class)
	@ApiOperation(value="用户查询服务getUserInfo")
	public User getUserInfo(@ApiParam(value="用户id")@PathVariable String id) {
		if(true) {
		throw new UserNotExistException(id);
		}	
		System.out.println(id);
		User user = new User("小明", "123", "12");
		return user;
	}
	
	@PostMapping
	@ApiOperation(value="用户创建服务createUser")
	public void createUser(@Valid @RequestBody User user /*,BindingResult errors*/) {
		/*if(errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}*/
		System.out.println(user);
	}
	
	@PutMapping("/{id:\\d+}")
	@ApiOperation(value="用户更新服务queryUserList")
	public void updateUser(@ApiParam(value="用户id")@PathVariable String id,@Valid @RequestBody User user/*,BindingResult errors*/) {
		/*if(errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}*/
		System.out.println(id);
		System.out.println(user);
	}
	
	@DeleteMapping("/{id:\\d+}")
	@ApiOperation(value="用户删除服务queryUserList")
	public void delete(@ApiParam(value="用户id")@PathVariable String id) {
		System.out.println(id);
	}

}
