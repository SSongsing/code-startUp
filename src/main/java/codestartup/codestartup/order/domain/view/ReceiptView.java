package codestartup.codestartup.order.domain.view;

import codestartup.codestartup.order.domain.Money;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReceiptView {
    private String payMethod;
    private Money payAmount;
    private PayDetailView payDetail;
}
