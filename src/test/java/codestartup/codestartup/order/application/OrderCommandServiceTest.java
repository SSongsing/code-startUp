package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.CategoryType;
import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.commands.OrderBookCommand;
import codestartup.codestartup.order.domain.repository.BookRepository;
import codestartup.codestartup.order.domain.repository.OrderRepository;
import codestartup.codestartup.order.domain.view.OrderBookView;
import codestartup.codestartup.order.interfaces.dto.OrderBookReqDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
class OrderCommandServiceTest {

    @InjectMocks
    OrderCommandService orderCommandService;
    @Mock
    OrderRepository orderRepository;
    @Mock
    BookRepository bookRepository;
    @Mock
    PayService payService;
    @Mock
    DiscountService discountService;

    @Test
    void IT_카테고리_할인_적용() {
        OrderBookReqDTO reqDTO = OrderBookReqDTO.builder().item(new OrderBookReqDTO.Item("1")).payMethod("CASH").payAmount(new Money(50000)).build();
        OrderBookCommand command = new OrderBookCommand(reqDTO);
        Book book = Book.builder().id(1L).price(new Money(20000)).name("test").category(CategoryType.IT.getValue()).build();
        List<Money> discountList = new ArrayList<>();
        discountList.add(new Money(1000));

        given(bookRepository.findById(any())).willReturn(Optional.of(book));
        given(discountService.getDiscountList(any())).willReturn(discountList);
        given(payService.pay(any(), any(), any())).willReturn(new Money(31000));

        OrderBookView result = orderCommandService.orderBook(command);
        assertEquals(new Money(1000).getMoneyValue(), result.getReceiptView().getPayDetail().getDiscountPrice().getMoneyValue());
    }

    @Test
    void 금요일_할인_적용() {
        OrderBookReqDTO reqDTO = OrderBookReqDTO.builder().item(new OrderBookReqDTO.Item("1")).payMethod("CASH").payAmount(new Money(50000)).build();
        OrderBookCommand command = new OrderBookCommand(reqDTO);
        Book book = Book.builder().id(1L).price(new Money(20000)).name("test").category(CategoryType.IT.getValue()).build();
        List<Money> discountList = new ArrayList<>();
        discountList.add(new Money(2000));

        given(bookRepository.findById(any())).willReturn(Optional.of(book));
        given(discountService.getDiscountList(any())).willReturn(discountList);
        given(payService.pay(any(), any(), any())).willReturn(new Money(32000));

        OrderBookView result = orderCommandService.orderBook(command);
        assertEquals(new Money(2000).getMoneyValue(), result.getReceiptView().getPayDetail().getDiscountPrice().getMoneyValue());
    }

    @Test
    void 할인_중복_적용() {
        OrderBookReqDTO reqDTO = OrderBookReqDTO.builder().item(new OrderBookReqDTO.Item("1")).payMethod("CASH").payAmount(new Money(50000)).build();
        OrderBookCommand command = new OrderBookCommand(reqDTO);
        Book book = Book.builder().id(1L).price(new Money(20000)).name("test").category(CategoryType.IT.getValue()).build();
        List<Money> discountList = new ArrayList<>();
        discountList.add(new Money(1000));
        discountList.add(new Money(2000));

        given(bookRepository.findById(any())).willReturn(Optional.of(book));
        given(discountService.getDiscountList(any())).willReturn(discountList);
        given(payService.pay(any(), any(), any())).willReturn(new Money(33000));

        OrderBookView result = orderCommandService.orderBook(command);
        assertEquals(new Money(3000).getMoneyValue(), result.getReceiptView().getPayDetail().getDiscountPrice().getMoneyValue());
    }
}