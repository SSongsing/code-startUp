package codestartup.codestartup.order.domain.discount;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.Money;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;


@Component
@NoArgsConstructor
public class DayDiscountPolicy implements DiscountPolicy {

    public DayDiscountPolicy(DayOfWeek DISCOUNT_DAY, DayOfWeek TODAY, double DISCOUNT_RATE) {
        this.DISCOUNT_DAY = DISCOUNT_DAY;
        this.TODAY = TODAY;
        this.DISCOUNT_RATE = DISCOUNT_RATE;
    }

    private DayOfWeek DISCOUNT_DAY = DayOfWeek.FRIDAY;
    private double DISCOUNT_RATE = 0.1;
    private DayOfWeek TODAY = LocalDateTime.now().getDayOfWeek();

    @Override
    public boolean isDiscountable(Book book) {

        return DISCOUNT_DAY.equals(TODAY);
    }
    @Override
    public Money getDiscountAmount(Book book) {
        return new Money(book.getPrice().getMoneyValue().multiply(BigDecimal.valueOf(DISCOUNT_RATE)));
    }
}
