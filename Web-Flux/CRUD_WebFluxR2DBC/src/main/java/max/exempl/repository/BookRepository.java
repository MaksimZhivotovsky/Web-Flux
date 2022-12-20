package max.exempl.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import max.exempl.model.Book;

public interface BookRepository extends ReactiveCrudRepository<Book, Long> {

}
