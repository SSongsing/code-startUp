package codestartup.codestartup.order.domain.view;

import lombok.Getter;

@Getter
public class ReceiptView {
    private String payMethod;
    private Integer payAmount;
    private PayDetailView payDetail;
}
