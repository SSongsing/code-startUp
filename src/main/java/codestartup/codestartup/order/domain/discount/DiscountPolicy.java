package codestartup.codestartup.order.domain.discount;

import codestartup.codestartup.order.domain.Book;

public interface DiscountPolicy {
    boolean isDiscountable(Book book);

    int getDiscountAmount(Book book);
}
