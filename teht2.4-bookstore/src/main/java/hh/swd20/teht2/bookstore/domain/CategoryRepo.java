package hh.swd20.teht2.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CategoryRepo extends CrudRepository<Category, Long> {

	List <Category> findByName(@Param("name") String name);

}
