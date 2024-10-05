package library.users;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, String> {
	
}
