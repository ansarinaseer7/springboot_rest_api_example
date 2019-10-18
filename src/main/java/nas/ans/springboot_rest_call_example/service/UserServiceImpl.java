package nas.ans.springboot_rest_call_example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nas.ans.springboot_rest_call_example.entity.User;
import nas.ans.springboot_rest_call_example.exception.RestApiException;
import nas.ans.springboot_rest_call_example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void createUser(User user) throws RestApiException {
		userRepository.save(user);
	}

	@Override
	public List<User> gerUsers() {
		return userRepository.findAll();
	}
	@Transactional
	@Override
	public void deleteUser(User user) {
		entityManager.remove(user);
	}

	@Override
	public void updateUser(User user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public User getUserById(Long id) {
		User user = userRepository.getOne(id);
		return user;
	}
}
