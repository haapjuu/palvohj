package hh.swd20.teht2.bookstore;


import hh.swd20.teht2.bookstore.domain.Book;
import hh.swd20.teht2.bookstore.domain.BookRepo;
import hh.swd20.teht2.bookstore.domain.Category;
import hh.swd20.teht2.bookstore.domain.CategoryRepo;
import hh.swd20.teht2.bookstore.domain.User;
import hh.swd20.teht2.bookstore.domain.UserRepo;

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
	public CommandLineRunner booksaveDemo(BookRepo bookRepo, CategoryRepo categoryRepo, UserRepo userRepo) { 
		return (args) -> {
			
			log.info("create categories");
			
			categoryRepo.save(new Category("scifi"));
			categoryRepo.save(new Category("comic"));	
			
			log.info("save books with categories");
				
			bookRepo.save(new Book("test author 1", "test comic 1", "DIS3890-1", 1999, 19.90, categoryRepo.findByName("comic")));
			bookRepo.save(new Book("test author 2", "test scifi 1", "ISBD832-5", 2014, 38.65, categoryRepo.findByName("scifi")));
			
			log.info("fetch all books");
			
			for(Book book : bookRepo.findAll()) {
				log.info(book.toString());
			}
			
			User user1 = new User("user", "$2a$04$G5PqiG7vl0t1aYCVkT7pt.yPFB1uBeYJ53QWlnVU8O3aFXNH09/Te", "user@bookstore.com","USER");
			User user2 = new User("admin", "$2a$04$O.yAQuuezI.z2Zbd3U8XGeQ2YDb8N2lSnJzbEdhzdZE0ODnJ1jf/G", "admin@bookstore.com", "ADMIN");
			userRepo.save(user1);
			userRepo.save(user2);
			
		};
	}
}
