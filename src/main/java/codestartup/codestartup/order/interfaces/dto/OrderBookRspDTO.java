package codestartup.codestartup.order.interfaces.dto;

import codestartup.codestartup.order.domain.OrderBookCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderBookRspDTO extends CommonRspDTO {
    private Receipt receipt;

    @Builder
    public OrderBookRspDTO(
            OrderBookCommand orderBookCommand,
            Integer originPrice,
            Integer discountPrice,
            List<Integer> discountList,
            Integer changeAmount
            ) {
        this.receipt = Receipt.builder()
                .orderBookCommand(orderBookCommand)
                .originPrice(originPrice)
                .discountPrice(discountPrice)
                .discountList(discountList)
                .changeAmount(changeAmount)
                .build();
    }

    @Getter
    public static class Receipt {
        private String payMethod;
        private Integer payAmount;
        private PayDetail payDetail;

        @Builder
        public Receipt(
                OrderBookCommand orderBookCommand,
                Integer originPrice,
                Integer discountPrice,
                List<Integer> discountList,
                Integer changeAmount
        ) {
            this.payAmount = orderBookCommand.getPayAmount();
            this.payMethod = orderBookCommand.getPayMethod();
            this.payDetail = new PayDetail(originPrice, discountPrice, changeAmount, discountList);
        }
    }

    @Getter
    private static class PayDetail {
        private Integer originPrice;
        private Integer discountPrice;
        private List<Integer> discountList;
        private Integer changeAmount;

        public PayDetail(Integer originPrice, Integer discountPrice, Integer changeAmount, List<Integer> discountList) {
            this.originPrice = originPrice;
            this.discountPrice = discountPrice;
            this.changeAmount = changeAmount;
            this.discountList = new ArrayList<>();
            discountList.addAll(discountList);
        }
    }
}
