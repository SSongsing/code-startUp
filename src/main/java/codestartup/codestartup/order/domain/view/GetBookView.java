package codestartup.codestartup.order.domain.view;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetBookView {
    private Long id;
    private String name;
    private String category;
    private Money originPrice;
    private Money discountPrice;
    private List<Money> discountList;

    @Builder
    public GetBookView(Book book, List<Money> discountList) {
        this.id = book.getId();
        this.name = book.getName();
        this.category = book.getCategory();
        this.originPrice = book.getPrice();
        this.discountList = new ArrayList<>();
        this.discountList.addAll(discountList);
        this.discountPrice = book.getPrice().subtract(discountList.stream().reduce(new Money(0), Money::sum));
    }
}