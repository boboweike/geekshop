/*
 * Copyright (c) 2020 掘艺网络(jueyi.co).
 * All rights reserved.
 */

package co.jueyi.geekshop.types.customer;

import co.jueyi.geekshop.types.address.Address;
import co.jueyi.geekshop.types.common.Node;
import co.jueyi.geekshop.types.history.HistoryEntryList;
import co.jueyi.geekshop.types.history.HistoryEntryListOptions;
import co.jueyi.geekshop.types.order.OrderList;
import co.jueyi.geekshop.types.order.OrderListOptions;
import co.jueyi.geekshop.types.user.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on Nov, 2020 by @author bobo
 */
@Data
public class Customer implements Node {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private String title;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private List<Address> addresses = new ArrayList<>();
    private OrderList orders;
    private User user;
    private Long userId; // 该字段仅内部使用，GraphQL对外不可见
    private List<CustomerGroup> groups = new ArrayList<>(); // 该字段只有Admin可见
    private HistoryEntryList history; // 该字段只有Admin可见
}
