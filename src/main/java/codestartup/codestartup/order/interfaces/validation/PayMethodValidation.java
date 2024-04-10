package codestartup.codestartup.order.interfaces.validation;

import codestartup.codestartup.order.domain.PayMethod;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = PayMethodValidation.Validator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface PayMethodValidation {
    String message() default "올바르지 않은 결제 방식입니다.";
    class Validator implements ConstraintValidator<PayMethodValidation, String> {
        @Override
        public void initialize(PayMethodValidation constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return PayMethod.contains(value);
        }
    }
}
