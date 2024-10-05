package library.topic;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.topic.books.Books;
import library.topic.books.BooksRepository;
import library.topic.books.BooksService;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private BooksService bookService;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics :: add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findById(id).orElse(null);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public String deleteTopic(String id) {
		List<Books> books = bookService.getAllBooks(id);
		if(books.size() == 0) {
			topicRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			return "Cannot Delete Topic " + id + ", first delete books inside the topic";
		}
	}
}
