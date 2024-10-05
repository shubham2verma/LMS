package library.topic.books;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//import org.springframework.context.annotation.Lazy;

import library.topic.Topic;

@Entity
public class Books {
	
	@Id
	private String 	bookId;	// name of the book
	private String 	author;
	private Integer available;
	private Integer total;
	
//	@Lazy
//	@ManyToOne(fetch = FetchType.LAZY)
//	@ManyToOne(cascade = {CascadeType.ALL})
	@ManyToOne
//	@ManyToOne(cascade = CascadeType.REMOVE)
	private Topic topic;
	
	public Books() {

	}
	
	public Books(String id, String author, String topicId) {
		super();
		this.bookId = id;
		this.author = author;
		this.topic = new Topic(topicId, "", "");
	}
	
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getId() {
		return bookId;
	}
	public void setId(String id) {
		this.bookId = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
}
