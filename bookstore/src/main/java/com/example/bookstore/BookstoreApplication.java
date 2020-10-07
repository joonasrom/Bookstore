package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;

import com.example.bookstore.model.User;
import com.example.bookstore.model.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner categoryDemo(CategoryRepository crepository, BookRepository repository, UserRepository urepository) {
		return (args) -> {

			Category c1 = new Category("Fantasy");
			Category c2 = new Category("Horror");
			Category c3 = new Category("Crime");
			Category c4 = new Category("Humor");

			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);
			crepository.save(c4);

			Book b1 = new Book("Harry Potter and the Philosopher's stone", "J.K.Rowling", 1997, "564-2-9-5624-2", 26.95,
					crepository.findByName("Fantasy").get(0));
			Book b2 = new Book("Frankenstein", "Mary Shelley", 1823, "978-0-30-5151-1", 132.95,
					crepository.findByName("Horror").get(0));
			
			repository.save(b1);
			repository.save(b2);
			
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "user@bookstore.fi");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "admin@bookstore.fi");
			urepository.save(user1);
			urepository.save(user2);
			

		};

	}

}
