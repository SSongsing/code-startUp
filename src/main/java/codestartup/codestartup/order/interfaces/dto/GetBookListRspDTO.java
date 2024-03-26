package codestartup.codestartup.order.interfaces.dto;

import codestartup.codestartup.order.domain.view.GetBookListView;
import codestartup.codestartup.order.domain.view.GetBookView;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class GetBookListRspDTO extends CommonRspDTO {
    private List<GetBookRspDTO> items;

    public GetBookListRspDTO(GetBookListView getBookListView) {
        this.items = new ArrayList<>();
        getBookListView.getBookList().forEach(getBookView -> {
            this.items.add(new GetBookRspDTO(getBookView));
        });
    }

    @Getter
    private static class GetBookRspDTO {
        private Integer id;
        private String name;
        private String category;
        @JsonProperty("origin_price")
        private Integer originPrice;
        @JsonProperty("discount_price")
        private Integer discountPrice;
        @JsonProperty("discount_list")
        private List<Integer> discountList;

        public GetBookRspDTO(GetBookView getBookView) {
            this.id = getBookView.getId();
            this.name = getBookView.getName();
            this.category = getBookView.getCategory();
            this.originPrice = getBookView.getOriginPrice();
            this.discountPrice = getBookView.getDiscountPrice();
            this.discountList = new ArrayList<>();
            this.discountList.addAll(getBookView.getDiscountList());
        }
    }
}
