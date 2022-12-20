package max.exempl.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import max.exempl.model.Book;
import max.exempl.repository.BookRepository;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class BookService {
	
	private final BookRepository bookRepository;

	public Flux<Book> getBooks() {
		
//		Flux<Book> books = bookRepository.getBooks();
		
		return bookRepository.getBooks();
	}

}
