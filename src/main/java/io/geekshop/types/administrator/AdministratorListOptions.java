/*
 * Copyright (c) 2020 GeekShop.
 * All rights reserved.
 */

package io.geekshop.types.administrator;

import io.geekshop.types.common.ListOptions;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * Created on Nov, 2020 by @author bobo
 */
@Data
public class AdministratorListOptions implements ListOptions {
    @Min(1)
    private Integer currentPage;
    @Min(1)
    private Integer pageSize;
    private AdministratorSortParameter sort;
    private AdministratorFilterParameter filter;
}
