package ch.jsch.lyl.backend.jpa.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.jsch.lyl.backend.jpa.domain.LuckyBoard;

public interface LuckyBoardRepository extends CrudRepository<LuckyBoard, Long> {

    LuckyBoard findById(Long id);
    
    @Query("select l from LuckyBoard l where l.name LIKE %:name% and l.description LIKE %:description%")
    Set<LuckyBoard> findByNameOrDescription(String name, String description);
   
}
