package library.userBookInfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.topic.books.Books;
import library.topic.books.BooksService;

@Service
public class UserBookInfoService {
	
	@Autowired
	private UserBookInfoRepository userBookInfoRepository;
	
	@Autowired
	private BooksService bookService;
	
	public List<List<String>> getIssuedBooks(String userId){
//	public List<UserBookInfo> getIssuedBooks(String userId){
		List<List<String>> bookIds = new ArrayList<>();
//		List<UserBookInfo> userBookInfo = new ArrayList<>();
		List<UserBookInfo> userBookInfo = userBookInfoRepository.findByUsersId(userId);
//		userBookInfoRepository.findAll()
//		userBookInfoRepos		itory.findAllById(userId)
//		.forEach(userBookInfo :: add);
		
		for(UserBookInfo key : userBookInfo) {
//			bookIds = key.getBook();
			List<String> details = new ArrayList<>();
			details.add(key.getBook().getId());
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			details.add(dateFormat.format(key.getIssueDate()));
//			details.add(key.getIssueDate().format, "dd-MM-yyyy"));
			bookIds.add(details);
//			bookIds.add(key.getBook().getId());
		}
		return bookIds;
//		return userBookInfo;
	}
	
//	public UserBookInfo getUser(String id) {
//		return userRepository.findById(id).orElse(null);
//	}

	public String borrowBook(String userId, String bookId) {
//		List<String> bookIds = getIssuedBooks(userId);
		List<List<String>> bookIds = getIssuedBooks(userId);
//		for(String key : bookIds) {
//			if(bookId.equals(key) == true) {
//				return userId + " Already has a copy of " + bookId; 
//			}
//		}
		for(List<String> key : bookIds) {
			if(bookId.equals(key.get(0)) == true) {
				return userId + " Already has a copy of " + bookId; 
			}
		}
		
		Books book = bookService.getBook(bookId);
		if(book.getAvailable() > 0 &&  book.getTotal() > 0) {
			book.setAvailable(book.getAvailable() - 1);
			bookService.updateBook(book);
			UserBookInfo obj = new UserBookInfo(bookId, userId);
			userBookInfoRepository.save(obj);
//			book.setTotal(book.getTotal() - 1);
//			book.setAvailable(book.getAvailable() - 1);
//			bookService.updateBook(book);
			return "Successfully Borrowed";
		} else {
			return "No Available books";
		}
		
		
	}
	
	public String returnBook(String userId, String bookId) {
//		List<String> bookIds = getIssuedBooks(userId);
		List<List<String>> bookIds = getIssuedBooks(userId);
		int flag = 0;
		
//		for(String key : bookIds) {
//			if(bookId.equals(key) == true) {
//				flag = 1;
//				break;
//			}
//		}
		for(List<String> key : bookIds) {
			if(bookId.equals(key.get(0)) == true) {
				flag = 1;
				break;
			}
		}
		
		if(flag == 0) {
			return userId + " does not have a " + bookId + " issued.";
		}
		
		Long id = 0L;
		List<UserBookInfo> userBookInfo = userBookInfoRepository.findByUsersId(userId);
		for(UserBookInfo key : userBookInfo) {
			if(key.getBook().getId().equals(bookId)) {
				id  = key.getId();
			}
		} 
	
		
		Books book = bookService.getBook(bookId);
		book.setAvailable(book.getAvailable() + 1);
		bookService.updateBook(book);
		String str = "Successfully Returned, Issue date was: " + bookIds.get(0).get(1);
		userBookInfoRepository.deleteById(id);
//		book.setTotal(book.getTotal() + 1);
//		book.setAvailable(book.getAvailable() + 1);
//		bookService.updateBook(book);
		return str;
	}
	
}
