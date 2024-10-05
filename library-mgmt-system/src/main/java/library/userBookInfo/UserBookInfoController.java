package library.userBookInfo;

//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserBookInfoController {
	
	@Autowired
	private UserBookInfoService userBookInfoService;
	
//	@RequestMapping("/users")
//	public List<UserBookInfo> getAllUsers() {
//		return userService.getAllUsers();
//	}
	
//	@RequestMapping("/users/{userId}/issuedBooks")
//	public List<UserBookInfo> getIssuedBooks(@PathVariable String userId) {
//		return userBookInfoService.getIssuedBooks(userId);
//	}
	
	@RequestMapping("/users/{userId}/issuedBooks")
//	public List<UserBookInfo> getIssuedBooks(@PathVariable String userId) {
//	public List<String> getIssuedBooks(@PathVariable String userId) {
	public List<List<String>> getIssuedBooks(@PathVariable String userId) {
		return userBookInfoService.getIssuedBooks(userId);
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/users")
	@RequestMapping("/users/{userId}/topics/{topicId}/books/{bookId}/borrowBook")
	public String borrowBook(@PathVariable String userId, @PathVariable String bookId) {
		// if userId already has bookId, return already have one, means a userId can have only single book of a bookId, also update available book count
		
		return userBookInfoService.borrowBook(userId, bookId);
	}
	
	@RequestMapping("/users/{userId}/topics/{topicId}/books/{bookId}/returnBook")
	public String returnBook(@PathVariable String userId, @PathVariable String bookId) {
//		if no mapping of bookId and userId, return not issued, also do not forget to update available book count, and delete userid and bookid entry from userBookInfo table
		return userBookInfoService.returnBook(userId, bookId);
	}

}
