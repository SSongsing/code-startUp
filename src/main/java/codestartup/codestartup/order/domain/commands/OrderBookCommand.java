package codestartup.codestartup.order.domain.commands;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderBookCommand {
    private String itemId;
    private String payMethod;
    private Integer payAmount;
}
