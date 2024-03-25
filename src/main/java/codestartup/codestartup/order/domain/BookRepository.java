package codestartup.codestartup.order.domain;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
}
