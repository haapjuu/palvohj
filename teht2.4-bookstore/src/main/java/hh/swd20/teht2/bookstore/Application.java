package hh.swd20.teht2.bookstore;


import hh.swd20.teht2.bookstore.domain.Book;
import hh.swd20.teht2.bookstore.domain.BookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepo bookRepo) { 
		return (args) -> {
			log.info("save some books");
			bookRepo.save(new Book("tyyppi1", "kirja1", "213123-3", 2001, 19.90));
			bookRepo.save(new Book("tyyppi2", "kirja2", "123-312", 1990, 3.50));	
			
			log.info("fetch all books");
			for (Book book : bookRepo.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
	
	
}
