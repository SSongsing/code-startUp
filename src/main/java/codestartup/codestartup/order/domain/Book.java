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
    @Embedded
    private Money price;

    public Boolean isBuyable(Money payAmount) {
        return !this.price.isGreaterThan(payAmount);
    }

    public Money getChangeAmount(OrderBookCommand orderBookCommand, Money discountPrice) {
        if (StringUtils.equals("CASH", orderBookCommand.getPayMethod())) {
            return new Money(
                    orderBookCommand.getPayAmount().getMoneyValue()
                            .subtract(this.price.getMoneyValue())
                            .add(discountPrice.getMoneyValue())
            );
        }
        return new Money(0);
    }
    // TODO: DDD
    // boundary
    // agg
    // 묻지말고 시켜라 => 안되면 내가 다 알아야된다 => 디펜던시 강결합 =>

    // Book.changeAuthor("request")
    // {
    // 뭔가 엄청많은 로직
    // }

    // 조회
    // 주문내역
    // document db
    //
    // {
//            "book"
    //     "page": "1"
    // }

    // Book.setAuthor("request") {
    //
    private String page;
    private String author;
}

// TODO: 질문을 하는 이유는
// 실제 면접
// 근데 왜 물어볼까요? 기술은 문제를 해결하기 위해나옴
// 기술을 배움 -> 무조건  씀 -> 복잡만 해짐
// 문제 == 바위를 깨야되요. 근데 배운건 가위질
// 기술을 배울때 이걸 언제쓰는지 왜쓰는지 알면 좋아요.