package max.exempl.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import max.exempl.handler.BookHandler;
import max.exempl.handler.BookStreamHandler;

@Configuration
public class RouterConfig {

    @Autowired
    private BookHandler handler;

    @Autowired
    private BookStreamHandler streamHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/router/books", handler::loadBooks)
                .GET("/router/books/stream", streamHandler::getBooks)
                .GET("/router/books/{id}", handler::findBook)
                .POST("/router/books", handler::saveBook)
                .build();

    }
}
