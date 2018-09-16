package vhcsoft.com.vhcsoft.blog.versioning.entities;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
	@Autowired
	private UserRepository userRepo;


	@Transactional
	public User updateUser(User u) {
		User user = userRepo.save(u);
		return user;
	}
}
