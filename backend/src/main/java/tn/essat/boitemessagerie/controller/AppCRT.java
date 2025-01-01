package tn.essat.boitemessagerie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.essat.boitemessagerie.dao.IMessage;
import tn.essat.boitemessagerie.dao.IUser;
import tn.essat.boitemessagerie.model.Message;
import tn.essat.boitemessagerie.model.User;


import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('ROLE_USER')")
public class AppCRT {

	@Autowired
	private IUser userDao ;
	@Autowired
	private IMessage messageDao; // Message DAO


	@RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
	public String preLogin(@RequestParam(value = "error", required = false) String error , Model model) {

	String msg = null;
	if (error != null) {
		msg = "Username or Password is incorrect !!";
		}

	model.addAttribute("errorMessge", msg);
	return "login";
	}



	@GetMapping("/verif/{username}/{password}")
	public User verifyUser(@PathVariable String username, @PathVariable String password) {
		User user = userDao.findByUsername(username);

		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}


	@GetMapping("/utilisateurs")
	public List<User> getAllUsers() {
		System.out.println(userDao.findAll().toString());
		return userDao.findAll();
	}


	@GetMapping("/utilisateur/{id}")
	public User getUserById(@PathVariable int id) {
		return userDao.findById(id).orElse(null);
	}


	@GetMapping("/messagesrecus/{id}")
	public List<Message> getReceivedMessages(@PathVariable int id) {
		return messageDao.findAllByUserreceiveId(id);
	}


	@GetMapping("/messagesenvoyes/{id}")
	public List<Message> getSentMessages(@PathVariable int id) {
		return messageDao.findAllByUsersendId(id);
	}


	@GetMapping("/message/{id}")
	public Message getMessageById(@PathVariable int id) {
		return messageDao.findById(id).orElse(null);
	}


	@PostMapping("/addMessage")
	public Message addMessage(@RequestBody Message message) {
		return messageDao.save(message);
	}

	// Delete a message by ID
	@DeleteMapping("/delMessage/{id}")
	public void deleteMessage(@PathVariable int id) {
		messageDao.deleteById(id);
	}
}