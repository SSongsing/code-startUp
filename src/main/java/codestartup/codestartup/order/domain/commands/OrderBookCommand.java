package codestartup.codestartup.order.domain.commands;

import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.Order;
import codestartup.codestartup.order.domain.pay.PayMethodType;
import codestartup.codestartup.order.interfaces.dto.OrderBookReqDTO;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderBookCommand {
    private String itemId;
    private PayMethodType payMethodType;
    private Money payAmount;

    public OrderBookCommand(OrderBookReqDTO orderBookReqDTO) {
        this.itemId = orderBookReqDTO.getItem().getId();
        this.payMethodType = PayMethodType.fromValue(orderBookReqDTO.getPayMethod());
        this.payAmount = orderBookReqDTO.getPayAmount();
    }

    public Order toEntity() {
        return new Order(Long.valueOf(itemId), payMethodType.getValue());
    }
}
