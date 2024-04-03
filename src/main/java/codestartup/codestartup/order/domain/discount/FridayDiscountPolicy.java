package codestartup.codestartup.order.domain.discount;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.Money;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

// TODO: 테스트 코드
// 모든 코드를 테스트 할 필요가 없다
// 중요한 테스트만,
// 테스트가 가능하도록 설계 하는 것 == OOP

@Component
@NoArgsConstructor
public class FridayDiscountPolicy implements DiscountPolicy {

    private DayOfWeek DISCOUNT_DAY_FRIDAY = DayOfWeek.FRIDAY;
    private String discountType = "DAY";
    private double DISCOUNT_RATE = 0.1;

    @Override
    public boolean isDiscountable(Book book, DayOfWeek dayOfWeek) {
        return DISCOUNT_DAY_FRIDAY.equals(dayOfWeek);
    }
    @Override
    public Money getDiscountAmount(Book book) {
        return new Money(book.getPrice().getValue().multiply(BigDecimal.valueOf(DISCOUNT_RATE)));
    }
}
