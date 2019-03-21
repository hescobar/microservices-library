package fr.hugoescobar.library.client.book.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.hugoescobar.library.client.book.model.Book;
import fr.hugoescobar.library.client.book.model.Genre;
import fr.hugoescobar.library.client.book.repository.BookRepository;

@RestController
public class BookRestController {

	@Autowired
	BookRepository repository;

	@RequestMapping("/init")
	public String init() {
		repository.saveAll(Arrays.asList(new Book("Fondation", "Isaac Asimov", Genre.SCIFI),
				new Book("Dune", "Frank Herbert", Genre.SCIFI), new Book("Hamlet", "William Shakespeare", Genre.DRAMA),
				new Book("Fifty Shades of Grey", "E. L. James", Genre.ROMANCE),
				new Book("Da Vinci Code", "Dan Brown", Genre.THRILLER)));

		return "Database initialized";
	}

	@RequestMapping("/all")
	public String findAll() {
		String result = "";
		for (Book book : repository.findAll()) {
			result += book.toString() + "<br>";
		}
		return result;
	}

	@RequestMapping("/find/id")
	public String findById(@RequestParam("id") long id) {
		String result = "";
		result = repository.findById(id).toString();
		return result;
	}

	@RequestMapping("/find/name")
	public String findByName(@RequestParam("name") String name) {
		String result = "";
		for (Book book : repository.findByName(name)) {
			result += book.toString() + "<br>";
		}
		return result;
	}

}
