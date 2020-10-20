package admin.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import admin.api.model.User;
import admin.api.repo.UserRepository;

@Service
public class UserServiceRest {
	@Autowired
	UserRepository userRepository;
	
	public void createUser(User user) {
		User userb = user;
		userb.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userRepository.insert(userb);
	}

}
