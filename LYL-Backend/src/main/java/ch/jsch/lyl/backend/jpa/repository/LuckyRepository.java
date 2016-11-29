package ch.jsch.lyl.backend.jpa.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import ch.jsch.lyl.backend.jpa.domain.Lucky;

public interface LuckyRepository extends CrudRepository<Lucky, Long> {

    Lucky findById(Long id);
    
    //@Query("select l from Lucky l where l.lucky l.title=%:title% and l.comment=%:comment%")
    Set<Lucky> findByTitleOrComment(String title, String comment);
   
}
