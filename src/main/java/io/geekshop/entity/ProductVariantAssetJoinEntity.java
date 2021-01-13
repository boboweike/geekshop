/*
 * Copyright (c) 2020 GeekShop.
 * All rights reserved.
 */

package io.geekshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created on Nov, 2020 by @author bobo
 */
@TableName(value = "tb_product_variant_asset_join")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductVariantAssetJoinEntity extends OrderableAsset {
    private Long productVariantId;
}
