package codestartup.codestartup.order.domain.discount;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.Money;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public interface DiscountPolicy {
    boolean isDiscountable(Book book, DayOfWeek dayOfWeek);
    Money getDiscountAmount(Book book);
}
