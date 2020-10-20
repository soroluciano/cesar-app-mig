package admin.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import admin.api.model.User;
import admin.api.services.UserServiceRest;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceRest userServiceRest;
	
	@CrossOrigin()
	@RequestMapping("/saveUser")
	@PostMapping
	public void saveUser(@Valid @RequestBody User user) {
		
		 this.userServiceRest.createUser(user);
	}
}
