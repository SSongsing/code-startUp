package codestartup.codestartup.order.domain.pay;

import codestartup.codestartup.order.domain.Money;

public interface PayMethod {
    Money pay(Money payAmount, Money price, Money discountPrice);
}
