package codestartup.codestartup.order.domain.commands;

import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.PayMethod;
import codestartup.codestartup.order.interfaces.dto.OrderBookReqDTO;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderBookCommand {
    private String itemId;
    private PayMethod payMethod;
    private Money payAmount;

    public OrderBookCommand(OrderBookReqDTO orderBookReqDTO) {
        this.itemId = orderBookReqDTO.getItem().getId();
        this.payMethod = PayMethod.fromValue(orderBookReqDTO.getPayMethod());
        this.payAmount = orderBookReqDTO.getPayAmount();
    }
}
