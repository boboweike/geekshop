/*
 * Copyright (c) 2020 GeekShop.
 * All rights reserved.
 */

package io.geekshop.types.common;

import lombok.Data;

/**
 * Created on Nov, 2020 by @author bobo
 */
@Data
public class Adjustment {
    private String adjustmentSource;
    private AdjustmentType type;
    private String description;
    private Integer amount;
}
