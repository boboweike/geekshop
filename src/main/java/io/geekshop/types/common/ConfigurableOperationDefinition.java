/*
 * Copyright (c) 2020 GeekShop.
 * All rights reserved.
 */

package io.geekshop.types.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on Nov, 2020 by @author bobo
 */
@Data
public class ConfigurableOperationDefinition {
    private String code;
    private List<ConfigArgDefinition> args = new ArrayList<>();
    private String description;
}
