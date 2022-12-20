package max.exempl.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;
import max.exempl.model.Book;
import max.exempl.repository.BookRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookStreamHandler {
	
	private final BookRepository bookRepository;

	   public Mono<ServerResponse> getBooks(ServerRequest request) {
	        Flux<Book> booksStream = bookRepository.getBooks();
	        return ServerResponse.ok().
	                contentType(MediaType.TEXT_EVENT_STREAM)
	                .body(booksStream, Book.class);
	    }
}
