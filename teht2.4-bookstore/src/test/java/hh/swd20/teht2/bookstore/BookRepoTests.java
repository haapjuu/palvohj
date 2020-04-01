package hh.swd20.teht2.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.teht2.bookstore.domain.Category;
import hh.swd20.teht2.bookstore.domain.CategoryRepo;
import hh.swd20.teht2.bookstore.domain.Book;
import hh.swd20.teht2.bookstore.domain.BookRepo;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepoTests {

	@Autowired BookRepo bookRepo;
	@Autowired CategoryRepo categoryRepo;
	
	@Test
	public void findByIsbn() {
		
		List<Book> books = bookRepo.findByIsbn("DIS3890-1");
		
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("test comic 1");
		
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("test author 1", "test comic 1", "DIS3890-1", 1999, 19.90, new Category("comic"));
		bookRepo.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
}
