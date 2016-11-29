// tag::sample[]
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
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String userName;
    private String userToken;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "LUCKYBOARDUSER_JOIN_T",
               joinColumns = @JoinColumn(name = "USER_ID"),
               inverseJoinColumns = @JoinColumn(name = "LUCKYBOARD_ID"))
	private Set<LuckyBoard> luckyBoards = new LinkedHashSet<LuckyBoard>();

	protected User() {}

    public User(String userName, String userToken) {
        this.userName = userName;
        this.userToken = userToken;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, firstName='%s', userToken='%s']",
                id, userName, userToken);
    }

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public String getUserToken() {
		return userToken;
	}
	
	public void setUserToken(String userToken){
		this.userToken = userToken;
	}
	
	 public Set<LuckyBoard> getLuckyBoards() {
		return luckyBoards;
	}

	public void setLuckyBoards(Set<LuckyBoard> luckyBoards) {
		this.luckyBoards = luckyBoards;
	}
}

