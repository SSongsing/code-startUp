package codestartup.codestartup.order.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@Table(name = "books")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private String category;

    private Integer price;

    @Column(name = "reg_date", updatable = false)
    @CreatedDate
    private LocalDateTime regDate;

    public Boolean isBuyable(Integer payAmount) {
        return payAmount >= this.price;
    }

}
