package library.userBookInfo;

import java.util.Date;
//import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import library.topic.books.Books;
import library.users.Users;

@Entity
public class UserBookInfo {
	
	@Id
	@GeneratedValue
	private Long id;
//	@ManyToOne(cascade = {CascadeType.ALL})
	@ManyToOne
//	private List<Books> book;
	private Books book;
//	@ManyToOne(cascade = {CascadeType.ALL})
	@ManyToOne
//	private List<Users> users;
	private Users users;

	
	@Temporal(TemporalType.DATE)
	private Date issueDate;
	
	public UserBookInfo() {

	}
	
//	public UserBookInfo(Integer id, String bookId, String userid) {
	public UserBookInfo(String bookId, String userId) {
		super();
//		this.id = id;
//		this.bookId = bookId;
//		this.userId = userId;
		this.book = new Books(bookId, "", "");
		this.users = new Users(userId, "");
//		users.add(new Users(userId, ""));
//		book.add(new Books(bookId, "", ""));
		this.issueDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	
	
	
//	public String getBookId() {
//		return bookId;
//	}
//
//	public void setBookId(String bookId) {
//		this.bookId = bookId;
//	}
//
//	public String getUserId() {
//		return userid;
//	}
//
//	public void setUserId(String userId) {
//		this.userid = userId;
//	}



	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}	
		
}
