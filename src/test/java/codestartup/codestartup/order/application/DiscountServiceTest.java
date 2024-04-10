package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.discount.DayDiscountPolicy;
import codestartup.codestartup.order.domain.discount.DiscountPolicy;
import codestartup.codestartup.order.domain.discount.ITCategoryDiscountPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DiscountServiceTest {
    DiscountService discountService;

    @Mock
    private List<DiscountPolicy> discountPolicies;
    @Mock
    private ITCategoryDiscountPolicy itCategoryDiscountPolicy;
    @Mock
    private DayDiscountPolicy fridayDiscountPolicy;

    @BeforeEach
    void setUp() {
        discountPolicies = new ArrayList<>();
        discountPolicies.add(itCategoryDiscountPolicy);
        discountPolicies.add(fridayDiscountPolicy);
        discountService = new DiscountService(discountPolicies);
    }

    @Test
    void 할인리스트조회() {

    }
}