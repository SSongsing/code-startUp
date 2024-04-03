package codestartup.codestartup.order.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

// TODO: 불변 값 객체로 만들어 볼 것. 2주차 얘기 해볼께요
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Money {
    private BigDecimal value;

    public Money(int value) {
        this.value = BigDecimal.valueOf(value);
    }

    public boolean isGreaterThan(Money comparedMoney) {
        return this.value.compareTo(comparedMoney.getValue()) > 1;
    }

    public Money sum(Money sumValue) {
        return new Money(sumValue.getValue().add(this.value));
    }

    public Money subtract(Money subtractMoney) {
        return new Money(this.value.subtract(subtractMoney.getValue()));
    }
}
