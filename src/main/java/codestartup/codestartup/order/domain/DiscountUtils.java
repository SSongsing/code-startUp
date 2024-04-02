package codestartup.codestartup.order.domain;

import codestartup.codestartup.order.domain.discount.DiscountPolicy;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class DiscountUtils {

//    private final repo
    private static Integer CATEGORY_FIXED_DISCOUNT_LIBERAL_ARTS = 1000;
    private static double DAY_RATE_DISCOUNT_FRIDAY = 0.1;

    public static List<Integer> getDiscountList(Book book) {
        //
        List<DiscountPolicy> discountPolicies = new ArrayList<>();

        // ocp
//        for (DiscountPolicy discountPolicy : discountPolicies) {
//            if (discountPolicy.isDiscountable(book)) {
//                System.out.println("TEST SUCCESS");
//                //
////                return List.of(discountPolicy.getDiscountAmount(book));
//            }
//        }

        ArrayList<Integer> discountList = new ArrayList<>();

        // ocp open closed principle
        Integer categoryDiscount = getCategoryDiscount(book);

        if (categoryDiscount != 0) {
            discountList.add(categoryDiscount);
        }
        Integer dayDiscount = getDayDiscount(book.getPrice() - categoryDiscount);
        if (dayDiscount != 0) {
            discountList.add(dayDiscount);
        }
        return discountList;
    }

    private static Integer getCategoryDiscount(Book book) {

        return CategoryType.LIBERAL_ARTS.getValue().equals(book.getCategory()) ? CATEGORY_FIXED_DISCOUNT_LIBERAL_ARTS: 0;
    }

    private static Integer getDayDiscount(Integer currentDiscountPrice) {
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.FRIDAY) ? (int) (DAY_RATE_DISCOUNT_FRIDAY * currentDiscountPrice) : 0;
    }
}
