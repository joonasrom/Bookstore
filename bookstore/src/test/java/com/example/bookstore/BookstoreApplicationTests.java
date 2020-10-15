package com.example.bookstore;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.model.UserRepository;
import com.example.bookstore.web.BookController;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookController bookController;

	@Autowired
	private UserRepository userRepo;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(userRepo).isNotNull();
	}

}