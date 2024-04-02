package codestartup.codestartup.order.domain.discount;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.CategoryType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ITCategoryDiscountPolicy implements DiscountPolicy{

    private String DISCOUNT_CATEGORY_IT = CategoryType.IT.getValue();
    private String DISCOUNT_TYPE = "CATEGORY";

    @Override
    public boolean isDiscountable(Book book, DayOfWeek dayOfWeek) {
        return StringUtils.equals(book.getCategory(), DISCOUNT_CATEGORY_IT);
    }

    @Override
    public int getDiscountAmount(Book book) {
        return 1000;
    }
}
