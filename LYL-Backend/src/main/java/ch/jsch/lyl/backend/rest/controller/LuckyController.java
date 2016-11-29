package ch.jsch.lyl.backend.rest.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.jsch.lyl.backend.jpa.domain.Lucky;
import ch.jsch.lyl.backend.jpa.repository.LuckyRepository;

@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("/lucky")
@RestController
public class LuckyController {
    
    @Autowired
    private LuckyRepository luckyRepo;
    
    @RequestMapping("/saveNewLucky")
    public Lucky saveNewUser(@RequestBody Lucky lucky) {
    	return luckyRepo.save(lucky);
    }
    
    @RequestMapping("/deleteLucky")
    public String deleteBoard(@RequestParam(value = "id") Long id) {
    	try{
    		luckyRepo.delete(id);
    		return "Successfully deleted Lucky with id: " + id.toString();
    	}
    	catch(Exception ex)
    	{
    		return "Failed to delete Lucky with id: " + id.toString() + ", error Message: " + ex.getMessage();
    	}
    }
    
    @RequestMapping("/getLuckyById")
    public Lucky getUserById(@RequestParam(value = "id") Long id) {

    		return luckyRepo.findOne(id);
    }
    
    @RequestMapping("/getUserByTitleOrComment")
    public Set<Lucky> findByNameOrComment(@RequestParam(value = "title") String title, @RequestParam(value = "comment") String comment) {

    		return luckyRepo.findByTitleOrComment(title, comment);
    }
}