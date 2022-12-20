package max.exempl.handler;

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
public class BookHandler {
	
    private final BookRepository dao;
    
    public Mono<ServerResponse> loadBooks(ServerRequest request){
        Flux<Book> booksList = dao.getBooksList();
        return ServerResponse.ok().body(booksList,Book.class);
    }


    public Mono<ServerResponse> findBook(ServerRequest request){
    	int bookId = Integer.valueOf( request.pathVariable("id"));
        Mono<Book> bookMono = dao.getBooksList().filter(c -> c.getId() == bookId).next();
        return ServerResponse.ok().body(bookMono,Book.class);
    }


    public Mono<ServerResponse> saveBook(ServerRequest request){
        Mono<Book> bookMono = request.bodyToMono(Book.class);
        Mono<String> saveResponse = bookMono.map(dto -> dto.getId() + ":" + dto.getTitle());
        return ServerResponse.ok().body(saveResponse,String.class);
    }

}
