package codestartup.codestartup.order.domain.repository;

import codestartup.codestartup.order.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();
    Optional<Book> findById(Integer id);
}
