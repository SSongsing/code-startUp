package codestartup.codestartup.order.infrastructure;

import codestartup.codestartup.order.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookJPARepositoryTest {

    @Autowired
    private BookJPARepository bookJPARepository;

    @Test
    void 아이디로_책_조회() {
        Optional<Book> result = bookJPARepository.findById(1);

        assertEquals(result.get().getId(), 1);
    }

    @Test
    void 모든_책_조회() {
        List<Book> bookList = bookJPARepository.findAll();

        assertEquals(4, bookList.size());
    }
}