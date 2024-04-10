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
    // TODO: discountRepository로 변경하기 것도 좋지만 service 로 빼도 좋다.
    private final DiscountService discountService;

    public GetBookListView getBookList() {
        // 2주차때 얘기
        List<Book> bookList = bookRepository.findAll();
        List<GetBookView> books = new ArrayList<>();
        for (Book book : bookList) {
            // TODO: builder == 많이 알고있다 == 커플링 == 강결합 == 결합도는 항상 낮추는게 좋다
            List<Money> discountList = discountService.getDiscountList(book);
            books.add(new GetBookView(book, discountList ));
        }

//        List<GetBookView> books = bookRepository.findAll()
//                .stream()
//                .map(book -> GetBookView.builder()
//                        .book(book)
//                        .discountList(getDiscountList(book, LocalDateTime.now().getDayOfWeek()))
//                        .build())
//                .toList();
        return new GetBookListView(books);
    }
}
