package library.users;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Users> getAllUsers(){
		List<Users> users = new ArrayList<>();
		userRepository.findAll()
		.forEach(users :: add);
		return users;
	}
	
	public Users getUser(String id) {
		return userRepository.findById(id).orElse(null);
	}

	public void addUser(Users users) {
		userRepository.save(users);
		
	}

	public void updateUser(String id, Users users) {
		userRepository.save(users);
	}

	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
}
