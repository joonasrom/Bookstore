package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByName() {
		List<Category> categoryList = crepository.findByName("Horror");
		
		assertThat(categoryList).hasSize(1);
		assertThat(categoryList.get(0).getName()).isEqualTo("Horror");
	}
	
	
	@Test
	public void deleteCategory() {
		crepository.delete(crepository.findByName("Horror").get(0));
		List<Category> categoryList = crepository.findByName("Horror");
		assertThat(categoryList).hasSize(0);
	}
	
	@Test
	public void createCategory() {
		Category category = new Category("Crime");
		crepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
		
	}
}