/*
 * Copyright (c) 2020 GeekShop.
 * All rights reserved.
 */

package io.geekshop.data_import.parser;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on Nov, 2020 by @author bobo
 */
@Data
public class ParsedProductVariant {
    private List<String> optionValues = new ArrayList<>();
    private String sku;
    private Float price;
    private Integer stockOnHand;
    private Boolean trackInventory;
    private List<String> assetPaths = new ArrayList<>();
    private List<StringFacet> facets = new ArrayList<>();
}

