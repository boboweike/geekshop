/*
 * Copyright (c) 2020 掘艺网络(jueyi.co).
 * All rights reserved.
 */

package co.jueyi.geekshop.types.order;

import co.jueyi.geekshop.types.common.Adjustment;
import co.jueyi.geekshop.types.common.Node;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on Nov, 2020 by @author bobo
 */
@Data
public class OrderItem implements Node {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private Boolean cancelled;
    private Integer unitPrice;
    private List<Adjustment> adjustments = new ArrayList<>();
    private Fulfillment fulfillment;
    private Long fulfillmentId; // // 内部使用，GraphQL不可见
    private Long refundId;
}
