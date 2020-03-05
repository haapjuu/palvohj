package hh.swd20.teht2.bookstore.domain;

import org.springframework.data.repository.CrudRepository;


public interface CategoryRepo extends CrudRepository<Category, Long> {





	
	public Category findByName(String name);

}
