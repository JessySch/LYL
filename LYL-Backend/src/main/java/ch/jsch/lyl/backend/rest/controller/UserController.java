package ch.jsch.lyl.backend.rest.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.jsch.lyl.backend.jpa.domain.User;
import ch.jsch.lyl.backend.jpa.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("/user")
@RestController
public class UserController {
    
    @Autowired
    private UserRepository usrRepo;
    
    @RequestMapping("/saveNewUser")
    public User saveNewUser(@RequestBody User user) {
    	return usrRepo.save(user);
    }
    
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam(value = "id") Long id) {
    	try{
    		usrRepo.delete(id);
    		return "Successfully deleted User with id: " + id.toString();
    	}
    	catch(Exception ex)
    	{
    		return "Failed to delete User with id: " + id.toString() + ", error Message: " + ex.getMessage();
    	}
    }
    
    @RequestMapping("/getUserById")
    public User getUserById(@RequestParam(value = "id") Long id) {

    		return usrRepo.findById(id);
    }
    
    @RequestMapping("/getUserByUserName")
    public Set<User> findByUserName(@RequestParam(value = "userName") String userName) {

    		return usrRepo.findByUserName(userName);
    }
    
    @RequestMapping("/getUserByUserToken")
    public User findByUserToken(@RequestParam(value = "userToken") String userToken) {

    		return usrRepo.findByUserToken(userToken);
    }
}