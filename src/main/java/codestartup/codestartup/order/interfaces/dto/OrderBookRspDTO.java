package codestartup.codestartup.order.interfaces.dto;

import codestartup.codestartup.order.domain.OrderBookCommand;
import codestartup.codestartup.order.domain.view.OrderBookView;
import codestartup.codestartup.order.domain.view.PayDetailView;
import codestartup.codestartup.order.domain.view.ReceiptView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    public static class Receipt {
        private String payMethod;
        private Integer payAmount;
        private PayDetail payDetail;

        public Receipt(ReceiptView receiptView) {
            this.payMethod = receiptView.getPayMethod();
            this.payAmount = receiptView.getPayAmount();
            this.payDetail = new PayDetail(receiptView.getPayDetail());
        }

    }

    @Getter
    private static class PayDetail {
        private Integer originPrice;
        private Integer discountPrice;
        private List<Integer> discountList;
        private Integer changeAmount;

        public PayDetail(PayDetailView payDetailView) {
            this.originPrice = payDetailView.getOriginPrice();
            this.discountPrice = payDetailView.getDiscountPrice();
            this.changeAmount = payDetailView.getChangeAmount();
            this.discountList = new ArrayList<>();
            this.discountList.addAll(payDetailView.getDiscountList());
        }

    }
}
