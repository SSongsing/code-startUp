package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.CategoryType;
import codestartup.codestartup.order.domain.commands.OrderBookCommand;
import codestartup.codestartup.order.domain.repository.BookRepository;
import codestartup.codestartup.order.domain.repository.OrderRepository;
import codestartup.codestartup.order.domain.view.OrderBookView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OrderCommandServiceTest {

    @InjectMocks
    OrderCommandService orderCommandService;
    @Mock
    OrderRepository orderRepository;
    @Mock
    BookRepository bookRepository;

    @Test
    void orderBookCheckChangeAmount() {
        OrderBookCommand command = OrderBookCommand.builder().itemId("1").payMethod("CASH").payAmount(50000).build();
        Book book = Book.builder().id(1).price(20000).name("test").category(CategoryType.DEVELOPMENT.getValue()).build();

        given(bookRepository.findById(any())).willReturn(Optional.of(book));

        OrderBookView result = orderCommandService.orderBook(command);
        assertEquals(result.getReceiptView().getPayDetail().getChangeAmount(), 30000);
    }
}