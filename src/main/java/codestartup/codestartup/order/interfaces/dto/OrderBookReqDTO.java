package codestartup.codestartup.order.interfaces.dto;

import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.interfaces.validation.PayAmountValidation;
import codestartup.codestartup.order.interfaces.validation.PayMethodValidation;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@ToString
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@PayAmountValidation
public class OrderBookReqDTO {
    @PayMethodValidation
    private String payMethod;
    private Money payAmount;
    private Item item;

    @Getter
    public static class Item {
        @NotBlank(message = "올바른 아이템을 골라주세요.")
        private String id;
    }
}
