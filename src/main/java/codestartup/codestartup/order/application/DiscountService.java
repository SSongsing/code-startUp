package codestartup.codestartup.order.application;

import codestartup.codestartup.order.domain.Book;
import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.domain.discount.DiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountService {
    // TODO
    // - CQRS
    // - Event
    // https://www.youtube.com/watch?v=704qQs6KoUk&t=821s&ab_channel=%EC%9A%B0%EC%95%84%ED%95%9C%ED%85%8C%ED%81%AC
    private final List<DiscountPolicy> discountPolicies;

    @Transactional
    public List<Money> getDiscountList(Book book) {
        List<Money> discountList = new ArrayList<>();
        for (DiscountPolicy discountPolicy : discountPolicies) {
            if (discountPolicy.isDiscountable(book)) {
                discountList.add(discountPolicy.getDiscountAmount(book));
            }
        }
        return discountList;
    }
}
