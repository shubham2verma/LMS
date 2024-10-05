package library.topic.books;

//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.topic.Topic;

@RestController
public class BooksController {
	
	@Autowired
	private BooksService bookService;
	
	@RequestMapping("/topics/{topicId}/books")
	public List<Books> getAllBooks(@PathVariable String topicId) {
		return bookService.getAllBooks(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/books/{id}")
	public Books getBook(@PathVariable String id) {
		return bookService.getBook(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/books")
	public void addBook(@RequestBody Books book, @PathVariable String topicId) {
		book.setTopic(new Topic(topicId, "", ""));
		bookService.addBook(book);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/books/{id}")
	public void updateBook(@RequestBody Books book, @PathVariable String topicId, @PathVariable String id) {
		book.setTopic(new Topic(topicId, "", ""));
		bookService.updateBook(book);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/books/{id}")
	public void deleteBook(@PathVariable String id) {
		bookService.deleteBook(id);
	}
	
//	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/books/{id}")
//	public void deleteSingleBook(@PathVariable String id) {
//		bookService.deleteSingleBook(id);
//	}
}
