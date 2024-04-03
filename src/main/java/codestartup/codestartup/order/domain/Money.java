package codestartup.codestartup.order.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

// TODO: 불변 값 객체로 만들어 볼 것. 2주차 얘기 해볼께요
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Embeddable
public class Money {
    @Column(name = "price")
    private BigDecimal moneyValue;

    public Money(int moneyValue) {
        this.moneyValue = BigDecimal.valueOf(moneyValue);
    }

    public boolean isGreaterThan(Money comparedMoney) {
        return this.moneyValue.compareTo(comparedMoney.getMoneyValue()) > 0;
    }

    public Money sum(Money sumValue) {
        return new Money(sumValue.getMoneyValue().add(this.moneyValue));
    }

    public Money subtract(Money subtractMoney) {
        return new Money(this.moneyValue.subtract(subtractMoney.getMoneyValue()));
    }
}
