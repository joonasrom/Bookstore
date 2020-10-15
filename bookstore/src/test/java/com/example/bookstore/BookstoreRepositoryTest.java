package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookstoreRepositoryTest {

	@Autowired
	private BookRepository brepository;

	@Autowired
	private CategoryRepository crepository;

	@Test
	public void createNewBook() {
		Book book = new Book("Seitsemän veljestä", "Aleksis Kivi", 1870, "321-55-251-2-1", 79.95,
				crepository.findByName("Novel").get(0));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void deleteBook() {
		brepository.delete(brepository.findByTitle("Frankenstein").get(0));
		List<Book> booklist = brepository.findByTitle("Frankenstein");
		assertThat(booklist).hasSize(0);

	}

	@Test
	public void findByBookTitle() {
		List<Book> bookList = brepository.findByTitle("Frankenstein");

		assertThat(bookList).hasSize(1);
		assertThat(bookList.get(0).getAuthor()).isEqualTo("Mary Shelley");
	}
}