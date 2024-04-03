package codestartup.codestartup.order.interfaces.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = OrderValidation.Validator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderValidation {

    class Validator implements ConstraintValidator<OrderValidation, String> {
        @Override
        public void initialize(OrderValidation constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return;
        }
    }
}
