/*
 * Copyright (c) 2020 极客之道(daogeek.io).
 * All rights reserved.
 */

package io.geekshop.config.auth;

import lombok.Data;

/**
 * Created on Nov, 2020 by @author bobo
 */
@Data
public class NativeAuthenticationData {
    private String username;
    private String password;
}