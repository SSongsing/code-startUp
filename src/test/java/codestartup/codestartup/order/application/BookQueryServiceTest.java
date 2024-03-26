package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.repository.BookRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)

class BookQueryServiceTest {

    @InjectMocks
    BookQueryService bookQueryService;
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