package codestartup.codestartup.order.infrastructure;

import codestartup.codestartup.order.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookJPARepositoryTest {

    @Autowired
    private BookJPARepository bookJPARepository;

    @Test
    void findById() {
        Book book = Book.builder().id(1).name("name").category("category").price(30000).build();
        bookJPARepository.saveAndFlush(book);
        Optional<Book> result = bookJPARepository.findById(1);

        assertEquals(result.get().getId(), book.getId());
    }
}