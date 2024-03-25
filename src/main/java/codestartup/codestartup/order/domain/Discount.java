package codestartup.codestartup.order.domain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Discount {
    private static Integer CATEGORY_FIXED_DISCOUNT_LIBERAL_ARTS = 1000;
    private static double DAY_RATE_DISCOUNT_FRIDAY = 0.1;
    public static Integer getTotalDiscount(Book book) {
        return getDayDiscount(getCategoryDiscount(book));
    }

    private static Integer getCategoryDiscount(Book book) {
        return CategoryType.LIBERAL_ARTS.getValue().equals(book.getCategory()) ? book.getPrice() - CATEGORY_FIXED_DISCOUNT_LIBERAL_ARTS: book.getPrice();
    }

    private static Integer getDayDiscount(Integer currentDiscountPrice) {
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.FRIDAY) ? (int) ((int) currentDiscountPrice * (1 - DAY_RATE_DISCOUNT_FRIDAY)) : currentDiscountPrice;
    }
}
