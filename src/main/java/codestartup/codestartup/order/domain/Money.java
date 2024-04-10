package codestartup.codestartup.order.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class Money {
    private BigDecimal moneyValue;

    public Money(int moneyValue) {
        this.moneyValue = BigDecimal.valueOf(moneyValue);
    }

    public Money(BigDecimal moneyValue) {
        this.moneyValue = moneyValue.setScale(0, RoundingMode.DOWN);
    }

    public boolean isGreaterThan(Money comparedMoney) {
        return this.moneyValue.compareTo(comparedMoney.getMoneyValue()) > 0;
    }

    public boolean isValid() {
        return this.moneyValue.compareTo(ZERO.getMoneyValue()) >= 0;
    }
    public Money sum(Money sumValue) {
        return new Money(sumValue.getMoneyValue().add(this.moneyValue));
    }

    public Money subtract(Money subtractMoney) {
        return new Money(this.moneyValue.subtract(subtractMoney.getMoneyValue()));
    }

    public Money multiply(BigDecimal multiplyNumber) {
        return new Money(this.moneyValue.multiply(multiplyNumber));
    }

    public static Money of(int moneyValue) {
        return new Money(moneyValue);
    }

    public static Money ZERO = new Money(0);

}
