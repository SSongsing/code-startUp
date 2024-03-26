package codestartup.codestartup.order.domain.view;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PayDetailView {
    private Integer originPrice;
    private Integer discountPrice;
    private List<Integer> discountList;
    private Integer changeAmount;

    @Builder
    public PayDetailView(Integer originPrice, Integer discountPrice, Integer changeAmount, List<Integer> discountList) {
        this.originPrice = originPrice;
        this.discountPrice = discountPrice;
        this.changeAmount = changeAmount;
        this.discountList = new ArrayList<>();
        this.discountList.addAll(discountList);
    }
}
