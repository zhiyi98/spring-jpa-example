package com.example.zhiyi.controller;

import com.example.zhiyi.entity.Users;
import com.example.zhiyi.service.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class UsersController {
	
	@Resource
	private UsersService usersService;
	
	@PostMapping("/save")
	public Users save(@RequestBody Users users) {
		users.setCreatedDate(new Date());
		Users saveUsers = null;
		try {
			saveUsers = this.usersService.save(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveUsers;
	}

}
