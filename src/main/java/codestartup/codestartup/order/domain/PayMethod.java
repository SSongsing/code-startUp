package codestartup.codestartup.order.domain;

public interface PayMethod {
    Money pay(Money payAmount, Money price, Money discountPrice);
}
