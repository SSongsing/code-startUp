package codestartup.codestartup.order.domain;

import org.springframework.stereotype.Component;

@Component
public class CashPayMethod implements PayMethod {
    @Override
    public Money pay(Money payAmount, Money price, Money discountPrice) {
        Money actualPayPrice = new Money(price.getMoneyValue().subtract(discountPrice.getMoneyValue()));
        return payAmount.subtract(actualPayPrice);
    }
}
