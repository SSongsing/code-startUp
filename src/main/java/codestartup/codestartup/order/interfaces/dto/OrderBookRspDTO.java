package codestartup.codestartup.order.interfaces.dto;

import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.view.OrderBookView;
import codestartup.codestartup.order.domain.view.PayDetailView;
import codestartup.codestartup.order.domain.view.ReceiptView;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class OrderBookRspDTO extends CommonRspDTO {
    private Receipt receipt;

    public OrderBookRspDTO(OrderBookView orderBookView) {
        this.receipt = new Receipt(orderBookView.getReceiptView());
    }

    @Getter
    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Receipt {
        private String payMethod;
        private Money payAmount;
        private PayDetail payDetail;

        public Receipt(ReceiptView receiptView) {
            this.payMethod = receiptView.getPayMethodType().getValue();
            this.payAmount = receiptView.getPayAmount();
            this.payDetail = new PayDetail(receiptView.getPayDetail());
        }

    }

    @Getter
    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    private static class PayDetail {
        private Money originPrice;
        private Money discountPrice;
        private List<Money> discountList;
        private Money changeAmount;

        public PayDetail(PayDetailView payDetailView) {
            this.originPrice = payDetailView.getOriginPrice();
            this.discountPrice = payDetailView.getDiscountPrice();
            this.changeAmount = payDetailView.getChangeAmount();
            this.discountList = new ArrayList<>();
            this.discountList.addAll(payDetailView.getDiscountList());
        }

    }
}
