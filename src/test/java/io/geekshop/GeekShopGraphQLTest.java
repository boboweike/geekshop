/*
 * Copyright (c) 2020 GeekShop.
 * All rights reserved.
 */

package io.geekshop;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created on Nov, 2020 by @author bobo
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest
@ActiveProfiles
public @interface GeekShopGraphQLTest {
    String[] value() default {};

    @AliasFor(
            annotation = ActiveProfiles.class
    )
    String[] profiles() default {"test"};

    @AliasFor(
            annotation = SpringBootTest.class
    )
    SpringBootTest.WebEnvironment webEnvironment() default SpringBootTest.WebEnvironment.RANDOM_PORT;
}
