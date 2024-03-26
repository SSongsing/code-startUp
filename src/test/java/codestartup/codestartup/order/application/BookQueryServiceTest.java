package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.repository.BookRepository;
import codestartup.codestartup.order.domain.view.GetBookListView;
import codestartup.codestartup.order.domain.view.GetBookView;
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
class BookQueryServiceTest {

    @InjectMocks
    BookQueryService bookQueryService;
    @Mock
    BookRepository bookRepository;

    @Test
    void getBookList() {
        List<Book> bookList = new ArrayList<>();
        Book book = Book.builder()
                .id(1)
                .name("차근차근 개발")
                .category("개발")
                .price(5000000)
                .build();
        bookList.add(book);
        List<GetBookView> getBookViewList = new ArrayList<>();
        List<Integer> discountList = new ArrayList<>();
        getBookViewList.add(GetBookView.builder().book(book).discountList(discountList).build());
        GetBookListView getBookListView = new GetBookListView(getBookViewList);

        given(bookRepository.findAll()).willReturn(bookList);
        GetBookListView result = bookQueryService.getBookList();

        assertThat(getBookListView).usingRecursiveComparison().isEqualTo(result);
    }
}