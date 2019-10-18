package nas.ans.springboot_rest_call_example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nas.ans.springboot_rest_call_example.entity.User;
import nas.ans.springboot_rest_call_example.entity.dto.UserDTO;
import nas.ans.springboot_rest_call_example.exception.RestApiException;
import nas.ans.springboot_rest_call_example.service.UserService;

@RestController
@RequestMapping("/example")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/user")
	public User createUser(@RequestBody User user) throws RestApiException {
		try {
			userService.createUser(user);
		} catch (RestApiException e) {
			System.out.println("Please provide an appropriate user.");//To be replaced by Logger
		}
		return user;
	}

	@GetMapping("/user")
	public List<User> getUsers() {
		return userService.gerUsers();
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Long id) {
		User user = userService.getUserById(id);
		userService.deleteUser(user);
	}

	@PutMapping("/user/{id}")
	public void updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
		User userToBeUpdated = userService.getUserById(id);
		userToBeUpdated.setAge(userDTO.getAge());
		userToBeUpdated.setName(userDTO.getName());
		userToBeUpdated.setSalary(userDTO.getSalary());
		
		userService.updateUser(userToBeUpdated);
	}
}
