package codestartup.codestartup.order.domain.discount;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.CategoryType;
import codestartup.codestartup.order.domain.Money;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CategoryDiscountPolicy implements DiscountPolicy{

    public CategoryDiscountPolicy(String DISCOUNT_CATEGORY, Money DISCOUNT_AMOUNT) {
        this.DISCOUNT_CATEGORY = DISCOUNT_CATEGORY;
        this.DISCOUNT_AMOUNT = DISCOUNT_AMOUNT;
    }
    private String DISCOUNT_CATEGORY;
    private Money DISCOUNT_AMOUNT;
    @Override
    public boolean isDiscountable(Book book) {
        return StringUtils.equals(book.getCategory(), this.DISCOUNT_CATEGORY);
    }

    @Override
    public Money getDiscountAmount(Book book) {
        return DISCOUNT_AMOUNT;
    }
}
