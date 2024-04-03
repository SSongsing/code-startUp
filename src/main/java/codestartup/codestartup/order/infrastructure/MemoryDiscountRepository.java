package codestartup.codestartup.order.infrastructure;


import codestartup.codestartup.order.domain.Discount;
import codestartup.codestartup.order.domain.discount.DayDiscountPolicy;
import codestartup.codestartup.order.domain.discount.DiscountPolicy;
import codestartup.codestartup.order.domain.repository.DiscountRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryDiscountRepository implements DiscountRepository {
    private static List<DiscountPolicy> store = List.of(
            new DayDiscountPolicy(1L, "DAY", 0.1),
            new DiscountPolicy(2L, "CATEGORY", 1000)
    );

    private static Cache<Long, Discount> cache;

    @Override
    public Optional<Discount> findById(Long id) {
        Discount discount = cache.get(id).orElseGet(() -> store.get(id));
        return Optional.ofNullable(discount);
    }

}
