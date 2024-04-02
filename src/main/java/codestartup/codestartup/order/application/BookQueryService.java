package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.Book;
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

import static codestartup.codestartup.order.domain.DiscountUtils.getDiscountList;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BookQueryService {
    private final BookRepository bookRepository;
    private final List<DiscountPolicy> discountPolicies;

    public GetBookListView getBookList() {
        // TODO stream은 왜 사용할까?
        // 2주차때 얘기
        List<Book> bookList = bookRepository.findAll();
        List<GetBookView> books = new ArrayList<>();
        for (Book book : bookList) {
            books.add(GetBookView.builder().book(book).discountList(getDiscountList(book, LocalDateTime.now().getDayOfWeek())).build());
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

    private List<Integer> getDiscountList(Book book, DayOfWeek dayOfToday) {
        List<Integer> discountList = new ArrayList<>();
        for (DiscountPolicy discountPolicy : discountPolicies) {
            if (discountPolicy.isDiscountable(book, dayOfToday)) {
                discountList.add(discountPolicy.getDiscountAmount(book));
            }
        }
        return discountList;
    }
}
