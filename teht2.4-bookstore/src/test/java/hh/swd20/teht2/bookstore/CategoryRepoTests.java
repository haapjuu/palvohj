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

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepoTests {

	@Autowired
	CategoryRepo categoryRepo;
	
	@Test
	public void createNewCategory() {
		Category category = new Category("drama");
		categoryRepo.save(category);
		assertThat(category.getCid()).isNotNull();
	}
	
	@Test
	public void findByCategoryName() {
		List<Category> categories = categoryRepo.findByName("comic");
		assertThat(categories).hasSize(1);
	}
	
	@Test
	public void deleteCategory() {
		
		Category category = new Category("thriller");
		categoryRepo.save(category);
		long cid = category.getCid();
		categoryRepo.delete(category);
		assertThat(categoryRepo.findById(cid)).isEmpty();
	}
	
}
