package max.exempl.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import max.exempl.model.Book;
import max.exempl.service.BookService;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/books")
public class BookController {
	
	private final BookService bookService;
	
	@GetMapping( produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Book> getBooks() {
		return bookService.getBooks();
	}
}
