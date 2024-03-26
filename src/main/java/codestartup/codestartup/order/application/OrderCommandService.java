package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.BookRepository;
import codestartup.codestartup.order.domain.Discount;
import codestartup.codestartup.order.domain.OrderBookCommand;
import codestartup.codestartup.order.interfaces.dto.OrderBookRspDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderCommandService {
    private final BookRepository bookRepository;

    @Transactional(rollbackOn = {Exception.class})
    public OrderBookRspDTO orderBook(OrderBookCommand orderBookCommand) {
        Optional<Book> book = bookRepository.findById(Integer.parseInt(orderBookCommand.getItemId()));
        if (book.isEmpty() || book.get().getPrice() > orderBookCommand.getPayAmount()) return new OrderBookRspDTO();

        List<Integer> discountList = Discount.getDiscountList(book.get());
        Integer discountPrice = discountList.stream().reduce(0, Integer::sum);
        Integer changeAmount = 0;
        if (orderBookCommand.getPayMethod().equals("CASH")) {
            changeAmount = orderBookCommand.getPayAmount() - book.get().getId() + discountPrice;
        }

        return OrderBookRspDTO.builder()
                .build();
    }
}
