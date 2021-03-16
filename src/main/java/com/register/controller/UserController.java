package com.register.controller;

import java.sql.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.register.bean.UserDetails;
import com.register.service.UserService;

@RestController
public class UserController {
	private static final Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	UserService userService;

	@GetMapping("/viewAll")
	public List<UserDetails> getList() {
		return userService.findAll();
	}

	@PostMapping("/createUser")
	public UserDetails saveUser(@RequestBody UserDetails user) {
		return userService.save(user);
	}

	@GetMapping("/viewAll/Name/{firstName}")
	public List<UserDetails> getByName(@PathVariable String firstName) {
		return userService.findByFirstName(firstName);
	}

	@GetMapping("/viewAll/date/{enteredDate}")
	public List<UserDetails> getByDate(@PathVariable Date enteredDate) {
		System.out.println(enteredDate);
		return userService.findAllByEnteredDate(enteredDate);
	}

	@GetMapping("/viewAll/Status/{userStatus}")
	public List<UserDetails> getByUserStatus(@PathVariable String userStatus) {
		return userService.findByUserStatus(userStatus);
	}

	@PutMapping("/updateUser")
	public String  getStatus(@RequestParam("userId") Integer userId,
			@RequestParam("userStatus") String userStatus) {
		userService.setUserStatus(userId, userStatus);
		return "Updated Successfully";

	}
	
	@PutMapping("/updateUserStatus")
	public String  updateStatus(@RequestParam("userId") Integer userId,
			@RequestParam("userStatus") String userStatus) {
		userService.setUserStatusUpdate(userId, userStatus);
		return "Updated Successfully";

	}
	

}
