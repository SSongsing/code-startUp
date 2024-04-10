package codestartup.codestartup.order.domain;

import org.springframework.stereotype.Component;

@Component
public class CardPayMethod implements PayMethod {
    @Override
    public Money pay(Money payAmount, Money price, Money discountPrice) {
        return Money.ZERO;
    }
}
