package ch.jsch.lyl.backend.rest.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.jsch.lyl.backend.jpa.domain.LuckyBoard;
import ch.jsch.lyl.backend.jpa.repository.LuckyBoardRepository;

@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("/luckyBoard")
@RestController
public class LuckyBoardController {
    
    @Autowired
    private LuckyBoardRepository boardRepo;
    
    @RequestMapping("/saveNewBoard")
    public LuckyBoard saveNewUser(@RequestBody LuckyBoard board) {
    	return boardRepo.save(board);
    }
    
    @RequestMapping("/deleteBoard")
    public String deleteBoard(@RequestParam(value = "id") Long id) {
    	try{
    		boardRepo.delete(id);
    		return "Successfully deleted LuckyBoard with id: " + id.toString();
    	}
    	catch(Exception ex)
    	{
    		return "Failed to delete LuckyBoard with id: " + id.toString() + ", error Message: " + ex.getMessage();
    	}
    }
    
    @RequestMapping("/getBoardById")
    public LuckyBoard getUserById(@RequestParam(value = "id") Long id) {

    	return boardRepo.findOne(id);
    }
    
    @RequestMapping("/getUserByNameOrDesc")
    public Set<LuckyBoard> findByNameOrDesc(@RequestParam(value = "name") String name, @RequestParam(value = "desc") String desc) {

    	return boardRepo.findByNameOrDescription(name, desc);
    }
}