package codestartup.codestartup.order.interfaces.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = StringToNumberValidation.Validator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface StringToNumberValidation {
    String message() default "올바르지 않은 숫자 형식입니다.";
    class Validator implements ConstraintValidator<StringToNumberValidation, String> {
        @Override
        public void initialize(StringToNumberValidation constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            try {
                Long.parseLong(value);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
}
