package codestartup.codestartup.order.interfaces.dto;

import codestartup.codestartup.order.domain.Money;
import codestartup.codestartup.order.interfaces.validation.PayAmountValidation;
import codestartup.codestartup.order.interfaces.validation.PayMethodValidation;
import codestartup.codestartup.order.interfaces.validation.StringToNumberValidation;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

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
    @AllArgsConstructor
    public static class Item {
        @StringToNumberValidation
        private String id;
    }
}
