package codestartup.codestartup.order.domain.discount;

import codestartup.codestartup.order.domain.Book;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public interface DiscountPolicy {
    boolean isDiscountable(Book book, DayOfWeek dayOfWeek);
    int getDiscountAmount(Book book);
}
