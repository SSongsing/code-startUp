package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.BookRepository;
import codestartup.codestartup.order.domain.GetBookListView;
import codestartup.codestartup.order.domain.GetBookView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)

class OrderQueryServiceTest {

    @InjectMocks
    OrderQueryService orderQueryService;
    @Mock
    BookRepository bookRepository;

//    @Test
//    void getBookList() {
//        List<Book> bookList = new ArrayList<>();
//        Book book = Book.builder()
//                .id(1)
//                .name("차근차근 개발")
//                .category("개발")
//                .price(5000000)
//                .build();
//        bookList.add(book);
//        List<GetBookView> getBookViewList = new ArrayList<>();
//        getBookViewList.add(GetBookView.builder().book(book).build());
//        GetBookListView getBookListView = new GetBookListView(getBookViewList);
//
//        given(bookRepository.findAll()).willReturn(bookList);
//        GetBookListView result = orderQueryService.getBookList();
//
//        assertThat(getBookListView).usingRecursiveComparison().isEqualTo(result);
//    }
}