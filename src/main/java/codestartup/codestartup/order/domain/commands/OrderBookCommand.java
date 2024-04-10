package codestartup.codestartup.order.domain.commands;

import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.Order;
import codestartup.codestartup.order.domain.PayMethodType;
import codestartup.codestartup.order.interfaces.dto.OrderBookReqDTO;
import lombok.Builder;
import lombok.Getter;
import org.aspectj.weaver.ast.Or;

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
