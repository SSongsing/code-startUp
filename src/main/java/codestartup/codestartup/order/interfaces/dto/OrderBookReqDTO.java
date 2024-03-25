package codestartup.codestartup.order.interfaces.dto;

import lombok.*;

import java.util.List;

@Getter
@ToString
public class OrderBookReqDTO {
    private String payMethod;
    private String payAmount;
    private Item item;

    @Getter
    public static class Item {
        private String id;
    }
}
