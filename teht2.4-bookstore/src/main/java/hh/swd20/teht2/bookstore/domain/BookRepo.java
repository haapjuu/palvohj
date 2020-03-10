package hh.swd20.teht2.bookstore.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepo extends CrudRepository<Book, Long> {

	Optional <Book> findByIsbn(@Param("isbn") String isbn);
		
}
