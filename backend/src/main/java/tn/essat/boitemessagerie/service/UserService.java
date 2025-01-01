package tn.essat.boitemessagerie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.essat.boitemessagerie.dao.IUser;
import tn.essat.boitemessagerie.model.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private IUser daoUser;  // Make sure IUser is an interface for user data access

	@Autowired
	private PasswordEncoder passwordEncoder;  // Autowire the PasswordEncoder

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		return daoUser.findByUsername(username);
	}

	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return daoUser.save(user); // Save the user with the hashed password
	}
}
