package codestartup.codestartup.order.domain.view;

import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.commands.OrderBookCommand;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReceiptView {
    private String payMethod;
    private Money payAmount;
    private PayDetailView payDetail;

    public ReceiptView(OrderBookCommand orderBookCommand, PayDetailView payDetail) {
        this.payAmount =orderBookCommand.getPayAmount();
        this.payMethod = orderBookCommand.getPayMethod();
        this.payDetail = payDetail;
    }
}
