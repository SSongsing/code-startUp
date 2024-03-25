package codestartup.codestartup.order.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetBookView {
    private Integer id;
    private String name;
    private String category;
    private Integer originPrice;
    private Integer discountPrice;

    @Builder
    public GetBookView(Book book, Integer discountPrice) {
        this.id = book.getId();
        this.name = book.getName();
        this.category = book.getCategory();
        this.originPrice = book.getPrice();
        this.discountPrice = discountPrice;
    }
}