package ch.jsch.lyl.backend.jpa.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import ch.jsch.lyl.backend.jpa.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findById(Long id);
	
	Set<User> findByUserName(String userName);
    
    User findByUserToken(String userToken);
}
