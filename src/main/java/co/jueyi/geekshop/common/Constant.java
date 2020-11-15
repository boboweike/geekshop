/*
 * Copyright (c) 2020 掘艺网络(jueyi.co).
 * All rights reserved.
 */

package co.jueyi.geekshop.common;

/**
 * Created on Nov, 2020 by @author bobo
 */
public abstract class Constant {
    public static final String DB_NAME_H2 = "h2";
    public static final String DB_NAME_MYSQL = "mysql";

    public static final String USERNAME_ANONYMOUS = "anonymous";
    public static final String USERNAME_SYSTEM = "system";

    public static final String PEBBLE_TEMPLATE_PREFIX = "templates/email/";
    public static final String PEBBLE_TEMPLATE_SUFFIX = ".pebble";

    public static final String REQUEST_ATTRIBUTE_CURRENT_USER = "GEEKSHOP_REQUEST_CURRENT_USER";

    public static final String COOKIE_NAME_TOKEN = "token";

    public static final String HTTP_HEADER_AUTHORIZATION = "Authorization";

    public static final String DEFAULT_ANONYMOUS_SESSION_DURATION = "1y";
    public static final String DEFAULT_REMEMBER_ME_DURATION = "1y";

    public static final int PASSWORD_LENGTH_MIN = 8;
    public static final int PASSWORD_LENGTH_MAX = 20;

    public static final int DEFAULT_CURRENT_PAGE = 1;
    public static final int DEFAULT_PAGE_SIZE = 100;

    public static final int DEFAULT_IN_MEMORY_CACHE_SIZE = 1000;

    public static final String NATIVE_AUTH_STRATEGY_NAME = "native";

    public static final String DEFAULT_AUTH_TOKEN_HEADER_KEY = "geekshop-shared-token";
    public static final String SUPER_ADMIN_USER_IDENTIFIER = "superadmin";
    public static final String SUPER_ADMIN_USER_PASSWORD = "superadmin123";

    public static final String DATA_LOADER_NAME_ADMINISTRATOR_USER = "administratorUserDataLoader";
    public static final String DATA_LOADER_NAME_HISTORY_ENTRY_ADMINISTRATOR = "historyEntryAdministrator";
    public static final String DATA_LOADER_NAME_CUSTOMER_USER = "customerUserDataLoader";
    public static final String DATA_LOADER_NAME_CUSTOMER_ADDRESSES = "customerAddressesDataLoader";
    public static final String DATA_LOADER_NAME_CUSTOMER_GROUPS = "customerGroupsDataLoader";
    public static final String DATA_LOADER_NAME_CUSTOMER_HISTORY = "customerHistoryDataLoader";
    public static final String DATA_LOADER_NAME_USER_ROLES = "userRolesDataLoader";
    public static final String DATA_LOADER_NAME_USER_AUTHENTICATION_METHODS = "userAuthenticationMethodsDataLoader";
    public static final String DATA_LOADER_NAME_CUSTOMER_GROUP_CUSTOMERS = "customerGroupCustomers";
}
