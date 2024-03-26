package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.repository.BookRepository;
import codestartup.codestartup.order.domain.view.GetBookListView;
import codestartup.codestartup.order.domain.view.GetBookView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static codestartup.codestartup.order.domain.DiscountUtils.getDiscountList;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BookQueryService {
    private final BookRepository bookRepository;

    public GetBookListView getBookList() {
        List<GetBookView> books = bookRepository.findAll()
                .stream()
                .map(book -> GetBookView.builder()
                        .book(book)
                        .discountList(getDiscountList(book))
                        .build())
                .toList();
        return new GetBookListView(books);
    }
}
