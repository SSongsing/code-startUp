package codestartup.codestartup.order.domain.discount;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.Money;

public interface DiscountPolicy {
    boolean isDiscountable(Book book);
    Money getDiscountAmount(Book book);
}
