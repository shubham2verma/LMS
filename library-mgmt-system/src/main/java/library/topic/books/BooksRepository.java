package library.topic.books;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, String> {
	
	public List<Books> findByTopicId(String topicId);

}
