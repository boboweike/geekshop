/*
 * Copyright (c) 2020 GeekShop.
 * All rights reserved.
 */

package io.geekshop.service.helpers.order_merger;

import lombok.Builder;
import lombok.Data;

/**
 * Created on Dec, 2020 by @author bobo
 */
@Data
@Builder
public class LineItem {
    private Long productVariantId;
    private Integer quantity;
}
