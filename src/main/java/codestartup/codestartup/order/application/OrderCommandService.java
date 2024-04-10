package codestartup.codestartup.order.application;

import codestartup.codestartup.common.ApiException;
import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.Order;
import codestartup.codestartup.order.domain.discount.DiscountPolicy;
import codestartup.codestartup.order.domain.repository.BookRepository;
import codestartup.codestartup.order.domain.commands.OrderBookCommand;
import codestartup.codestartup.order.domain.repository.OrderRepository;
import codestartup.codestartup.order.domain.view.OrderBookView;
import codestartup.codestartup.order.domain.view.PayDetailView;
import codestartup.codestartup.order.domain.view.ReceiptView;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderCommandService {
    private final DiscountService discountService;
    private final PayService payService;
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;

    @Transactional(rollbackOn = {Exception.class})
    public OrderBookView orderBook(OrderBookCommand orderBookCommand) {
        // List<MyError> list
        // list.add(new MyError("bookId", "책이 없습니다."));
        // if list.size() > 0
        // exception들을 List에 넣고, throw new ApiException(list)

        Book book = bookRepository.findById(orderBookCommand.getBookId())
                .filter(b -> b.isBuyable(orderBookCommand.getPayAmount()))
                .orElseThrow(() -> new ApiException("잘못된 주문입니다.", HttpStatus.BAD_REQUEST));

        List<Money> discountList = discountService.getDiscountList(book);

        Money discountPrice = discountList.stream().reduce(Money.ZERO, Money::sum);

        Money changeAmount = payService.pay(orderBookCommand, book, discountPrice);

        Order order = orderBookCommand.toEntity();
        orderRepository.saveAndFlush(order);

        PayDetailView payDetailView = new PayDetailView(book.getPrice(), discountPrice, changeAmount, discountList);
        ReceiptView receiptView = new ReceiptView(orderBookCommand, payDetailView);
        return new OrderBookView(receiptView);
    }
}
