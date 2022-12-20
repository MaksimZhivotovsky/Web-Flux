package max.exempl.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import max.exempl.model.Book;
import max.exempl.repository.BookRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookService {

	private final BookRepository bookRepository;
	
	public Flux<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	public Mono<Book> saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Mono<Book> findBookById(Long id) {
		return bookRepository.findById(id);
	}
	
	public void deleteBook(Long id) { 
		bookRepository.deleteById(id);
	}
}
