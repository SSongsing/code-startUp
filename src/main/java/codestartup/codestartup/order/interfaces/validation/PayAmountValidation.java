package codestartup.codestartup.order.interfaces.validation;


import codestartup.codestartup.order.interfaces.dto.OrderBookReqDTO;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

@Constraint(validatedBy = PayAmountValidation.Validator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface PayAmountValidation {
    // payMethod에 따라 payAmount 검증이 달라짐
    class Validator implements ConstraintValidator<PayAmountValidation, OrderBookReqDTO> {
        @Override
        public void initialize(PayAmountValidation constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(OrderBookReqDTO orderBookReqDTO, ConstraintValidatorContext context) {
            if (StringUtils.equals(orderBookReqDTO.getPayMethod(), "CASH")
                    || Objects.isNull(orderBookReqDTO.getPayAmount())
                    || !orderBookReqDTO.getPayAmount().isValid()) {
                return false;
            }
            return true;
        }
    }
}
