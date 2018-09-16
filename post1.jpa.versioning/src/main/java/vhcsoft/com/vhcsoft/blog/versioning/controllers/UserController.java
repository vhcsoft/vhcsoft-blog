package vhcsoft.com.vhcsoft.blog.versioning.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vhcsoft.com.vhcsoft.blog.versioning.entities.User;
import vhcsoft.com.vhcsoft.blog.versioning.entities.UserRepository;
import vhcsoft.com.vhcsoft.blog.versioning.entities.UserServices;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserServices userService;
	

	@GetMapping
	public Collection<User> getUsers() {

		Collection<User> users = new ArrayList<>();
		userRepository.findAll().forEach(i -> {
			users.add(i);
		});
		return users;
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		User editedUser = userService.updateUser(user);
		return editedUser;
	}
}
