package codestartup.codestartup.order.domain.view;

import codestartup.codestartup.order.domain.Book;
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
    private Integer originPrice;
    private Integer discountPrice;
    private List<Integer> discountList;

    @Builder
    public GetBookView(Book book, List<Integer> discountList) {
        this.id = book.getId();
        this.name = book.getName();
        this.category = book.getCategory();
        this.originPrice = book.getPrice();
        this.discountList = new ArrayList<>();
        this.discountList.addAll(discountList);
        this.discountPrice = book.getPrice() - discountList.stream().reduce(0, Integer::sum);
    }
}