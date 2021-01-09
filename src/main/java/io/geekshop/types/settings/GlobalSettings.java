/*
 * Copyright (c) 2020 GeekXYZ.
 * All rights reserved.
 */

package io.geekshop.types.settings;

import lombok.Data;

import java.util.Date;

/**
 * Created on Nov, 2020 by @author bobo
 */
@Data
public class GlobalSettings {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private Boolean trackInventory;
    private ServerConfig serverConfig;
}
