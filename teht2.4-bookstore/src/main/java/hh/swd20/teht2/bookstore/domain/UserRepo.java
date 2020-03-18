package hh.swd20.teht2.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
	User findByUsername(String username);
	
} 