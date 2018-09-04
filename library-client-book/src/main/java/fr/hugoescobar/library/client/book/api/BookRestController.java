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

	@RequestMapping("/save")
	public String process() {
		// save a single Customer
		repository.save(new Book("Fondation", "Isaac Asimov", Genre.SCIFI));

		// save a list of Customers
		repository.saveAll(Arrays.asList(new Book("Dune", "Frank Herbert", Genre.SCIFI),
				new Book("Hamlet", "William Shakespeare", Genre.DRAMA),
				new Book("Fifty Shades of Grey", "E. L. James", Genre.ROMANCE),
				new Book("Da Vinci Code", "Dan Brown", Genre.THRILLER)));

		return "Done";
	}
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "";
		
		for(Book book : repository.findAll()){
			result += book.toString() + "<br>";
		}
		return result;
	}
	
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findById(id).toString();
		return result;
	}
	
	@RequestMapping("/findbyname")
	public String fetchDataByLastName(@RequestParam("name") String name){
		String result = "";
		
		for(Book book: repository.findByName(name)){
			result += book.toString() + "<br>"; 
		}
		
		return result;
	}

}
