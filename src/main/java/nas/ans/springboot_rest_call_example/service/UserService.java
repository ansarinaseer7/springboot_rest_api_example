package nas.ans.springboot_rest_call_example.service;

import java.util.List;

import nas.ans.springboot_rest_call_example.entity.User;
import nas.ans.springboot_rest_call_example.exception.RestApiException;


public interface UserService {
	public void createUser(User user) throws RestApiException;
	public List<User> gerUsers();
	public void deleteUser(User user);
	public void updateUser(User user);
	public User getUserById(Long id);
}
