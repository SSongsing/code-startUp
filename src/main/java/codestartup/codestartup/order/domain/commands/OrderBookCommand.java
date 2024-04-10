package codestartup.codestartup.order.domain.commands;

import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.Order;
import codestartup.codestartup.order.domain.pay.PayMethodType;
import codestartup.codestartup.order.interfaces.dto.OrderBookReqDTO;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderBookCommand {
    private Long bookId;
    private PayMethodType payMethodType;
    private Money payAmount;

    public OrderBookCommand(OrderBookReqDTO orderBookReqDTO) {
        // 생성자에 검증
        this.bookId = Long.valueOf(orderBookReqDTO.getItem().getId());
        this.payMethodType = PayMethodType.fromValue(orderBookReqDTO.getPayMethod());
        this.payAmount = orderBookReqDTO.getPayAmount();
    }

    public Order toEntity() {
        return new Order(bookId, payMethodType.getValue());
    }
}
