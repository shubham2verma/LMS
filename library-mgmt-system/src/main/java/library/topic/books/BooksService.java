package library.topic.books;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
	
	@Autowired
	private BooksRepository bookRepository;
	
	public List<Books> getAllBooks(String topicId){
		List<Books> books = new ArrayList<>();
		bookRepository.findByTopicId(topicId)
		.forEach(books :: add);
		return books;
	}
	
	public Books getBook(String id) {
		return bookRepository.findById(id).orElse(null);
	}

	public void addBook(Books book) {
		String id = book.getId();
//		Books test = getBook(id);
		boolean test = bookRepository.existsById(id);
		
		if(test == false) {
			book.setTotal(1);
			book.setAvailable(1);
			bookRepository.save(book);
		} else {
			Books testBook = getBook(id);
			Integer total = testBook.getTotal() + 1;
			Integer available = testBook.getAvailable() + 1;
			book.setTotal(total);
			book.setAvailable(available);
			bookRepository.save(book);
		}
	}

	public void updateBook(Books book) {
		bookRepository.save(book);
	}

	public void deleteBook(String id) {
		Books book = getBook(id);
		
		if(book.getAvailable() == book.getTotal()) {
			bookRepository.deleteById(id);
		} else {
			System.out.println("!!!Available books of " + id + " are not equal to total books!!!");
		}
	}
	
//	public void deleteSingleBook(String id) {
////		Books book = bookRepository.findById(id).orElse(null);
//		Books book = getBook(id);
//		
//		if(book.getTotal() > 0 && book.getAvailable() > 0) {
//			book.setTotal(book.getTotal() - 1);
//			book.setAvailable(book.getAvailable() - 1);
//			bookRepository.save(book);
//		} else if(book.getTotal() == 0 && book.getAvailable() == 0) {
//			deleteBook(id);
//		} else {
//			System.out.println("!!!Exception!!!");
//		}
//	}
}
