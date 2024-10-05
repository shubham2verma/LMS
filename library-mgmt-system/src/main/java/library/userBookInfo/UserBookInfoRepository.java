package library.userBookInfo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//import library.topic.books.Books;

public interface UserBookInfoRepository extends CrudRepository<UserBookInfo, Long> {

	public List<UserBookInfo> findByUsersId(String userId);
}
