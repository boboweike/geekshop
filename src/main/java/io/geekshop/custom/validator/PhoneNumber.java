/*
 * Copyright (c) 2020 GeekXYZ.
 * All rights reserved.
 */

package io.geekshop.custom.validator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * Created on Nov, 2020 by @author bobo
 */
@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    String message() default "手机号码格式有问题";
    Class[] groups() default {};
    Class[] payload() default {};
}
