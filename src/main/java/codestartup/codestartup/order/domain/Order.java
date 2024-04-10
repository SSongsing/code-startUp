package codestartup.codestartup.order.domain;

import codestartup.codestartup.order.domain.commands.OrderBookCommand;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long bookId;

    private String payMethod;

    @CreatedDate
    private LocalDateTime regDate;

    public Order(Long bookId, String payMethod) {
        this.bookId = bookId;
        this.payMethod = payMethod;
    }

}
