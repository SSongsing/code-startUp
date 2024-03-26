package codestartup.codestartup.order.interfaces.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@Getter
@ToString
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderBookReqDTO {
    private String payMethod;
    private Integer payAmount;
    private Item item;

    @Getter
    public static class Item {
        private String id;
    }
}
