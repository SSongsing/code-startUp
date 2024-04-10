package codestartup.codestartup.order.domain;

import codestartup.codestartup.order.domain.commands.OrderBookCommand;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String category;

    private Money price;

    public Boolean isBuyable(Money payAmount) {
        return !this.price.isGreaterThan(payAmount);
    }

    private String page;
    private String author;
}