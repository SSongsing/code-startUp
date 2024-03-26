package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.BookRepository;
import codestartup.codestartup.order.domain.Discount;
import codestartup.codestartup.order.domain.OrderBookCommand;
import codestartup.codestartup.order.domain.view.OrderBookView;
import codestartup.codestartup.order.domain.view.PayDetailView;
import codestartup.codestartup.order.domain.view.ReceiptView;
import codestartup.codestartup.order.interfaces.dto.OrderBookRspDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderCommandService {
    private final BookRepository bookRepository;

    @Transactional(rollbackOn = {Exception.class})
    public OrderBookView orderBook(OrderBookCommand orderBookCommand) {
        Optional<Book> book = bookRepository.findById(Integer.parseInt(orderBookCommand.getItemId()));
        if (book.isEmpty() || book.get().getPrice() > orderBookCommand.getPayAmount()) return new OrderBookView();

        List<Integer> discountList = Discount.getDiscountList(book.get());
        Integer discountPrice = discountList.stream().reduce(0, Integer::sum);
        Integer changeAmount = 0;
        if (orderBookCommand.getPayMethod().equals("CASH")) {
            changeAmount = orderBookCommand.getPayAmount() - book.get().getPrice() + discountPrice;
        }
        PayDetailView payDetailView = PayDetailView.builder()
                .originPrice(book.get().getPrice())
                .changeAmount(changeAmount)
                .discountPrice(discountPrice)
                .discountList(discountList)
                .build();
        ReceiptView receiptView = ReceiptView.builder().payMethod(orderBookCommand.getPayMethod()).payAmount(orderBookCommand.getPayAmount()).payDetail(payDetailView).build();
        return OrderBookView.builder().receiptView(receiptView).build();
    }
}
