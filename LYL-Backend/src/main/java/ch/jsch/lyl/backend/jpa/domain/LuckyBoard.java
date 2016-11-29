package ch.jsch.lyl.backend.jpa.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class LuckyBoard {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String name;
    private String description;
    private String targetDate;
    
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "LUCKYBOARDUSER_JOIN_T",
//               joinColumns = @JoinColumn(name = "LUCKYBOARD_ID"),
//               inverseJoinColumns = @JoinColumn(name = "USER_ID"))
//	private Set<User> cards = new LinkedHashSet<User>();
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "LUCKYBOARDS_JOIN_T",
               joinColumns = @JoinColumn(name = "LUCKYBOARD_ID"),
               inverseJoinColumns = @JoinColumn(name = "LUCKY_ID"))
	private Set<Lucky> luckies = new LinkedHashSet<Lucky>();
    
    protected LuckyBoard() {}

    public LuckyBoard(String name, String description, String targetDate) {
        this.name = name;
        this.description = description;
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return String.format(
                "LuckyBoard[id=%d, name='%s', desc='%s', targetDate='%s']",
                id, name, description, targetDate);
    }
    
    public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	
//	public Set<User> getCards() {
//		return cards;
//	}
//
//	public void setCards(Set<User> cards) {
//		this.cards = cards;
//	}

	public Set<Lucky> getLuckies() {
		return luckies;
	}

	public void setLuckies(Set<Lucky> luckies) {
		this.luckies = luckies;
	}


}
