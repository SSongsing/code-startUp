package codestartup.codestartup.order.domain.view;

import codestartup.codestartup.order.domain.Money;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PayDetailView {
    private Money originPrice;
    private Money discountPrice;
    private List<Money> discountList;
    private Money changeAmount;

    @Builder
    public PayDetailView(Money originPrice, Money discountPrice, Money changeAmount, List<Money> discountList) {
        this.originPrice = originPrice;
        this.discountPrice = discountPrice;
        this.changeAmount = changeAmount;
        this.discountList = new ArrayList<>();
        this.discountList.addAll(discountList);
    }
}
