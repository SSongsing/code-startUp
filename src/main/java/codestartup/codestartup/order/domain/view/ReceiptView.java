package codestartup.codestartup.order.domain.view;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReceiptView {
    private String payMethod;
    private Integer payAmount;
    private PayDetailView payDetail;
}
