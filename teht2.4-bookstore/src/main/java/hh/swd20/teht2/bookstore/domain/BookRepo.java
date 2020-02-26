package hh.swd20.teht2.bookstore.domain;

import org.springframework.data.repository.CrudRepository;


public interface BookRepo extends CrudRepository<Book, Long> {






	
	public Book findByTitle(String title);

}
