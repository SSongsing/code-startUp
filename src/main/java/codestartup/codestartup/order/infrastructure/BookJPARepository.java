package codestartup.codestartup.order.infrastructure;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.BookRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookJPARepository extends BookRepository, JpaRepository<Book, Integer> {
    Optional<Book> findById(Integer id);
    Book saveAndFlush(Book book);
}
