package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.discount.DiscountPolicy;
import codestartup.codestartup.order.domain.repository.BookRepository;
import codestartup.codestartup.order.domain.view.GetBookListView;
import codestartup.codestartup.order.domain.view.GetBookView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BookQueryService {
    private final BookRepository bookRepository;
    private final DiscountService discountService;

    public GetBookListView getBookList() {
        List<Book> bookList = bookRepository.findAll();

        List<GetBookView> books = new ArrayList<>();
        for (Book book : bookList) {
            List<Money> discountList = discountService.getDiscountList(book);
            books.add(new GetBookView(book, discountList ));
        }

        return new GetBookListView(books);
    }
}
