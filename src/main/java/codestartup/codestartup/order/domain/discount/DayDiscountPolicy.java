package codestartup.codestartup.order.domain.discount;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.Money;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.DayOfWeek;


@Component
@NoArgsConstructor
public class DayDiscountPolicy implements DiscountPolicy {

    public DayDiscountPolicy(DayOfWeek DISCOUNT_DAY_FRIDAY, String discountType, double DISCOUNT_RATE) {
        this.DISCOUNT_DAY_FRIDAY = DISCOUNT_DAY_FRIDAY;
        this.discountType = discountType;
        this.DISCOUNT_RATE = DISCOUNT_RATE;
    }

    private DayOfWeek DISCOUNT_DAY_FRIDAY = DayOfWeek.FRIDAY;
    private String discountType = "DAY";
    private double DISCOUNT_RATE = 0.1;

    @Override
    public boolean isDiscountable(Book book, DayOfWeek dayOfWeek) {

        return DISCOUNT_DAY_FRIDAY.equals(dayOfWeek);
    }
    @Override
    public Money getDiscountAmount(Book book) {
        return new Money(book.getPrice().getMoneyValue().multiply(BigDecimal.valueOf(DISCOUNT_RATE)));
    }
}
