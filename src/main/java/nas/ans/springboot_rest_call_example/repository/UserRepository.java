package nas.ans.springboot_rest_call_example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nas.ans.springboot_rest_call_example.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public void deleteById(Long id);
	public Long deleteByName(String name);
}
