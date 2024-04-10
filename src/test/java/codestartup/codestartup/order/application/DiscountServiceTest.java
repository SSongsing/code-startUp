package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.CategoryType;
import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.discount.CategoryDiscountPolicy;
import codestartup.codestartup.order.domain.discount.DayDiscountPolicy;
import codestartup.codestartup.order.domain.discount.DiscountPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class DiscountServiceTest {
    DiscountService discountService;

    @Mock
    private List<DiscountPolicy> discountPolicies;
    @Mock
    private CategoryDiscountPolicy categoryDiscountPolicy;
    @Mock
    private DayDiscountPolicy dayDiscountPolicy;

    @BeforeEach
    void setUp() {
        discountPolicies = new ArrayList<>();
        discountPolicies.add(categoryDiscountPolicy);
        discountPolicies.add(dayDiscountPolicy);
        discountService = new DiscountService(discountPolicies);
    }

    @Test
    void 카테고리만할인() {
        Book book = Book.builder().id(1L).price(new Money(20000)).name("test").category(CategoryType.IT.getValue()).build();
        given(categoryDiscountPolicy.isDiscountable(any())).willReturn(true);
        given(categoryDiscountPolicy.getDiscountAmount(any())).willReturn(new Money(1000));
        given(dayDiscountPolicy.isDiscountable(any())).willReturn(false);
        List<Money> actual = new ArrayList<>();
        actual.add(new Money(1000));

        List<Money> result = discountService.getDiscountList(book);

        assertEquals(actual.get(0).getMoneyValue(), result.get(0).getMoneyValue());
    }
}