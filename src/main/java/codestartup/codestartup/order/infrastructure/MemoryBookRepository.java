package codestartup.codestartup.order.infrastructure;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryBookRepository implements BookRepository {
    private static Map<Long, Book> store = new HashMap<>();

    public MemoryBookRepository() {
        Book book1 = Book.builder().price(new Money(50000)).name("제목").category("IT").id(1L).build();
        store.put(book1.getId(), book1);
    }
    @Override
    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return Optional.ofNullable(store.get(id));
    }
}
