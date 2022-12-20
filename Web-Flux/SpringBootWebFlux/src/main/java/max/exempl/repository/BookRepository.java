package max.exempl.repository;

import java.time.Duration;

import org.springframework.stereotype.Component;

import max.exempl.model.Book;
import reactor.core.publisher.Flux;

@Component
public class BookRepository {

    public Flux<Book> getBooks()  {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
                .map(i -> new Book(i, "customer" + i));
    }
    
    public Flux<Book> getBooksList()  {
        return Flux.range(1,50)
                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
                .map(i -> new Book(i, "customer" + i));
    }
}
