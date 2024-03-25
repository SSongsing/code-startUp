package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static codestartup.codestartup.order.domain.Discount.getDiscountList;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrderQueryService {
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
