package codestartup.codestartup.order.application;

import codestartup.codestartup.common.ApiException;
import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.Order;
import codestartup.codestartup.order.domain.discount.DiscountPolicy;
import codestartup.codestartup.order.domain.repository.BookRepository;
import codestartup.codestartup.order.domain.DiscountUtils;
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
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;
    private final List<DiscountPolicy> discountPolicies;

    @Transactional(rollbackOn = {Exception.class})
    public OrderBookView orderBook(OrderBookCommand orderBookCommand) {
        Book book = bookRepository.findById(Integer.parseInt(orderBookCommand.getItemId()))
                .filter(b -> b.isBuyable(orderBookCommand.getPayAmount()))
                .orElseThrow(() -> new ApiException("잘못된 주문입니다.", HttpStatus.BAD_REQUEST));

        List<Integer> discountList = getDiscountList(book, LocalDateTime.now().getDayOfWeek());
        // TODO: stream은 왜쓸까?
        Integer discountPrice = discountList.stream().reduce(0, Integer::sum);
        Integer changeAmount = book.getChangeAmount(orderBookCommand, discountPrice);

        Order order = new Order(orderBookCommand.getItemId(), orderBookCommand.getPayMethod());
        orderRepository.saveAndFlush(order);

        ReceiptView receiptView = ReceiptView.builder()
                .payMethod(orderBookCommand.getPayMethod())
                .payAmount(orderBookCommand.getPayAmount())
                .payDetail(new PayDetailView(book.getPrice(), discountPrice, changeAmount, discountList))
                .build();
        return new OrderBookView(receiptView);
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
