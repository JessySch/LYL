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
public class Lucky {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	private String title;
    private String comment;
    private String url;
    
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "LUCKYBOARDS_JOIN_T",
//               joinColumns = @JoinColumn(name = "LUCKY_ID"),
//               inverseJoinColumns = @JoinColumn(name = "LUCKYBOARD_ID"))
//	private Set<LuckyBoard> luckyBoards = new LinkedHashSet<LuckyBoard>();
    
    protected Lucky() {}

    public Lucky(String title, String comment, String url) {
        this.title = title;
        this.comment = comment;
        this.url = url;
    }

    @Override
    public String toString() {
        return String.format(
                "LuckyBoard[id=%d, title='%s', comment='%s', url='%s']",
                id, title, comment, url);
    }
    
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

//	public Set<LuckyBoard> getLuckyBoards() {
//		return luckyBoards;
//	}
//
//	public void setLuckyBoards(Set<LuckyBoard> luckyBoards) {
//		this.luckyBoards = luckyBoards;
//	}
}
