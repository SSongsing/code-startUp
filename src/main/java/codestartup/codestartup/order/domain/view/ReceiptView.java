package codestartup.codestartup.order.domain.view;

import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.pay.PayMethodType;
import codestartup.codestartup.order.domain.commands.OrderBookCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
