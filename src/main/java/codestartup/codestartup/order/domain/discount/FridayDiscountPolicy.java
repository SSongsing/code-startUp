package codestartup.codestartup.order.domain.discount;

import codestartup.codestartup.order.domain.Book;

// TODO: 테스트 코드
// 모든 코드를 테스트 할 필요가 없다
// 중요한 테스트만,
// 테스트가 가능하도록 설계 하는 것 == OOP

public class FridayDiscountPolicy implements DiscountPolicy{

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
