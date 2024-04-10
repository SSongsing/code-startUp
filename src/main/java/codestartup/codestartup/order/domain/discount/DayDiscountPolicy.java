package codestartup.codestartup.order.domain.discount;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.Money;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDateTime;


@Component
@NoArgsConstructor
@RequiredArgsConstructor
public class DayDiscountPolicy implements DiscountPolicy {

    private Clock clock = Clock.systemDefaultZone();

    private DayOfWeek DISCOUNT_DAY;
    private double DISCOUNT_RATE = 0.1;

    @Override
    public boolean isDiscountable(Book book) {
        return LocalDateTime.now(clock).getDayOfWeek().equals(DISCOUNT_DAY);
    }
    @Override
    public Money getDiscountAmount(Book book) {
        return new Money(book.getPrice().getMoneyValue().multiply(BigDecimal.valueOf(DISCOUNT_RATE)));
    }
}
