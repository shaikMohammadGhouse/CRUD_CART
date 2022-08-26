package com.shoppingcart.app.validator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValuesAllowedValidator.Validator.class })
public @interface ValuesAllowedValidator {

    String message() default "Field value should be from list of ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String propName();

    String[] values();

    class Validator implements ConstraintValidator<com.shoppingcart.app.validator.ValuesAllowedValidator, String> {
        private String propName;
        private String message;
        private List<String> allowable;

        @Override
        public void initialize(com.shoppingcart.app.validator.ValuesAllowedValidator requiredIfChecked) {
            this.propName = requiredIfChecked.propName();
            this.message = requiredIfChecked.message();
            this.allowable = Arrays.asList(requiredIfChecked.values());
        }

        public boolean isValid(String value, ConstraintValidatorContext context) {
            Boolean valid = value == null || this.allowable.contains(value);

            if (!valid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(message.concat(this.allowable.toString()))
                        .addPropertyNode(this.propName).addConstraintViolation();
            }
            return valid;
        }
    }
}
