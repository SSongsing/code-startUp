package codestartup.codestartup.order.domain.discount;

import codestartup.codestartup.order.domain.Book;

public class  ITCategoryDiscountPolicy implements DiscountPolicy{

    private double rate = 0.1;

    @Override
    public boolean isDiscountable(Book book) {
        book.getCategory();
        return false;
    }

    @Override
    public int getDiscountAmount(Book book) {
        book.getPrice() * rate
        return 0;
    }
}
