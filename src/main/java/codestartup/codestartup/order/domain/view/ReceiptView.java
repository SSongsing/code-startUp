package codestartup.codestartup.order.domain.view;

import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.pay.PayMethodType;
import codestartup.codestartup.order.domain.commands.OrderBookCommand;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReceiptView {
    private PayMethodType payMethodType;
    private Money payAmount;
    private PayDetailView payDetail;

    public ReceiptView(OrderBookCommand orderBookCommand, PayDetailView payDetail) {
        this.payAmount =orderBookCommand.getPayAmount();
        this.payMethodType = orderBookCommand.getPayMethodType();
        this.payDetail = payDetail;
    }
}
