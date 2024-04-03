package codestartup.codestartup.order.domain.commands;

import codestartup.codestartup.order.domain.Money;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderBookCommand {
    private String itemId;
    private String payMethod;
    private Money payAmount;
}
