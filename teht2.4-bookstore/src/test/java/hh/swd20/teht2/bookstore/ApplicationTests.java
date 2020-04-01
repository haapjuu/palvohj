package hh.swd20.teht2.bookstore;

import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.teht2.bookstore.web.BookController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	BookController bcontroller;
	
	@Test
	public void contextLoads() {
		assertThat(bcontroller).isNotNull();
	}	

}
