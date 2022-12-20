package max.exempl.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import max.exempl.model.Book;
import max.exempl.service.BookService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/books")
public class BookController {

	private final BookService bookService;
	
	@GetMapping
	public Flux<Book> getBook() {
		return bookService.getBooks();
	}
	
	@PostMapping
	public Mono<Book> saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@GetMapping(value = "/{id}") 
	public Mono<Book> getBookById(@PathVariable("id") Long id) {
		return bookService.findBookById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
}
