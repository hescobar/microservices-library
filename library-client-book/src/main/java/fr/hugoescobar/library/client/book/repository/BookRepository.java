package fr.hugoescobar.library.client.book.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.hugoescobar.library.client.book.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByName(String name);
}
