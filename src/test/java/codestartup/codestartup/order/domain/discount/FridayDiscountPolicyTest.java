package codestartup.codestartup.order.domain.discount;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.CategoryType;
import codestartup.codestartup.order.domain.Money;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.*;

class FridayDiscountPolicyTest {

    @Test
    void 금요일_할인_적용_가능() {
        Book book = Book.builder().id(1L).price(new Money(20000)).name("test").category(CategoryType.IT.getValue()).build();
        FridayDiscountPolicy fridayDiscountPolicy = new FridayDiscountPolicy();

        boolean discountable = fridayDiscountPolicy.isDiscountable(book, DayOfWeek.FRIDAY);

        assertEquals(true, discountable);
    }

    @Test
    void 금요일_10프로_할인_성공() {
        Book book = Book.builder().id(1L).price(new Money(20000)).name("test").category(CategoryType.IT.getValue()).build();
        FridayDiscountPolicy fridayDiscountPolicy = new FridayDiscountPolicy();

        Money discountAmount = fridayDiscountPolicy.getDiscountAmount(book);

        assertEquals(new Money(2000), discountAmount);
    }
}