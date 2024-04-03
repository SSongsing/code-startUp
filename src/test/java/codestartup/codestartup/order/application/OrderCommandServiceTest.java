package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.CategoryType;
import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.commands.OrderBookCommand;
import codestartup.codestartup.order.domain.discount.DiscountPolicy;
import codestartup.codestartup.order.domain.discount.FridayDiscountPolicy;
import codestartup.codestartup.order.domain.discount.ITCategoryDiscountPolicy;
import codestartup.codestartup.order.domain.repository.BookRepository;
import codestartup.codestartup.order.domain.repository.OrderRepository;
import codestartup.codestartup.order.domain.view.OrderBookView;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderCommandServiceTest {

    OrderCommandService orderCommandService;
    @Mock
    OrderRepository orderRepository;
    @Mock
    BookRepository bookRepository;
    @Mock
    private List<DiscountPolicy> discountPolicies;
    @Mock
    private ITCategoryDiscountPolicy itCategoryDiscountPolicy;
    @Mock
    private FridayDiscountPolicy fridayDiscountPolicy;

    @BeforeEach
    void setUp() {
        discountPolicies = new ArrayList<>();
        discountPolicies.add(itCategoryDiscountPolicy);
        discountPolicies.add(fridayDiscountPolicy);
        orderCommandService = new OrderCommandService(bookRepository, orderRepository, discountPolicies);
    }
    @Test
    void IT_카테고리_할인_적용() {
        OrderBookCommand command = OrderBookCommand.builder().itemId("1").payMethod("CASH").payAmount(new Money(50000)).build();
        Book book = Book.builder().id(1L).price(new Money(20000)).name("test").category(CategoryType.IT.getValue()).build();

        given(bookRepository.findById(any())).willReturn(Optional.of(book));
        given(itCategoryDiscountPolicy.isDiscountable(any(), any())).willReturn(true);
        given(itCategoryDiscountPolicy.getDiscountAmount(any())).willReturn(new Money(1000));
        given(fridayDiscountPolicy.isDiscountable(any(), any())).willReturn(false);

        OrderBookView result = orderCommandService.orderBook(command);
        assertEquals(new Money(1000).getValue(), result.getReceiptView().getPayDetail().getDiscountPrice().getValue());
    }

    @Test
    void 금요일_할인_적용() {
        OrderBookCommand command = OrderBookCommand.builder().itemId("1").payMethod("CASH").payAmount(new Money(50000)).build();
        Book book = Book.builder().id(1L).price(new Money(20000)).name("test").category(CategoryType.IT.getValue()).build();

        given(bookRepository.findById(any())).willReturn(Optional.of(book));
        given(itCategoryDiscountPolicy.isDiscountable(any(),any())).willReturn(false);
        given(fridayDiscountPolicy.isDiscountable(any(), any())).willReturn(true);
        given(fridayDiscountPolicy.getDiscountAmount(any())).willReturn(new Money(2000));

        OrderBookView result = orderCommandService.orderBook(command);
        assertEquals(new Money(2000).getValue(), result.getReceiptView().getPayDetail().getDiscountPrice().getValue());
    }

    @Test
    void 할인_중복_적용() {
        OrderBookCommand command = OrderBookCommand.builder().itemId("1").payMethod("CASH").payAmount(new Money(50000)).build();
        Book book = Book.builder().id(1L).price(new Money(20000)).name("test").category(CategoryType.IT.getValue()).build();

        given(bookRepository.findById(any())).willReturn(Optional.of(book));
        given(itCategoryDiscountPolicy.isDiscountable(any(),any())).willReturn(true);
        given(itCategoryDiscountPolicy.getDiscountAmount(any())).willReturn(new Money(1000));
        given(fridayDiscountPolicy.isDiscountable(any(), any())).willReturn(true);
        given(fridayDiscountPolicy.getDiscountAmount(any())).willReturn(new Money(2000));

        OrderBookView result = orderCommandService.orderBook(command);
        assertEquals(new Money(3000).getValue(), result.getReceiptView().getPayDetail().getDiscountPrice().getValue());
    }
}