/*
 * Copyright (c) 2020 掘艺网络(jueyi.co).
 * All rights reserved.
 */
drop all objects delete files;

create table tb_user (
    id bigint not null auto_increment,
    deleted_at datetime,
    identifier varchar(50),
    verified boolean not null default false,
    last_login datetime,
    created_by varchar(50),
    created_at datetime,
    updated_by varchar(50),
    updated_at datetime,
    primary key (id),
    unique key (identifier)
);

create index idx_user_identifier on tb_user(identifier);

create table tb_auth_method (
    id bigint not null auto_increment,
    user_id bigint not null,
    external boolean not null default false,
    /* begin for native shared */
    identifier varchar(50),
    password_hash varchar(255),
    verification_token varchar(100),
    password_reset_token varchar(100),
    identifier_change_token varchar(100),
    pending_identifier varchar(50),
    /* end for native shared */

    /* begin for external shared */
    strategy varchar(50),
    external_identifier varchar(50),
    metadata text,
    /* end for external shared */
    created_by varchar(50),
    created_at datetime,
    updated_by varchar(50),
    updated_at datetime,
    primary key (id)
);

create index idx_auth_method_user_id on tb_auth_method(user_id);
create index idx_auth_method_verification_token on tb_auth_method(verification_token);
create index idx_auth_method_password_reset_token on tb_auth_method(password_reset_token);
create index idx_auth_method_identifier_change_token on tb_auth_method(identifier_change_token);
create index idx_auth_method_external_identifier on tb_auth_method(external_identifier);

create table tb_role (
    id bigint not null auto_increment,
    code varchar(50) not null,
    description varchar(255) not null,
    permissions text,
    created_by varchar(50),
    created_at datetime,
    updated_by varchar(50),
    updated_at datetime,
    primary key (id)
);

create index idx_role_code on tb_role(code);

create table tb_user_role_join (
     id bigint not null auto_increment,
     user_id bigint not null ,
     role_id bigint not null ,
     created_by varchar(50),
     created_at datetime,
     updated_by varchar(50),
     updated_at datetime,
     primary key (id),
     unique key (user_id, role_id),
     foreign key (role_id) references tb_role(id),
     foreign key (user_id) references tb_user(id)
);

create table tb_customer (
    id bigint not null auto_increment,
    deleted_at datetime,
    title varchar(50),
    first_name varchar(50),
    last_name varchar(50),
    phone_number varchar(50),
    email_address varchar(50),
    user_id bigint,
    created_by varchar(50),
    created_at datetime,
    updated_by varchar(50),
    updated_at datetime,
    primary key (id),
    foreign key (user_id) references tb_user(id)
);
create index idx_customer_user_id on tb_customer(user_id);

create table tb_administrator (
    id bigint not null auto_increment,
    first_name varchar(50),
    last_name varchar(50),
    email_address varchar(50),
    user_id bigint,
    deleted_at datetime,
    created_by varchar(50),
    created_at datetime,
    updated_by varchar(50),
    updated_at datetime,
    primary key (id),
    unique key (email_address),
    foreign key (user_id) references tb_user(id)
);
create index idx_administrator_user_id on tb_administrator(user_id);

create table tb_address (
     id bigint not null auto_increment,
     customer_id bigint not null,
     full_name varchar(50) not null default '',
     company varchar(50) not null default '',
     street_line1 varchar(100) not null,
     street_line2 varchar(100) not null default '',
     city varchar(50) not null default '',
     province varchar(50) not null default '',
     postal_code varchar(50) not null default '',
     phone_number varchar(50) not null default '',
     default_shipping_address boolean default false,
     default_billing_address boolean default false,
     created_by varchar(50),
     created_at datetime,
     updated_by varchar(50),
     updated_at datetime,
     primary key (id),
     foreign key (customer_id) references tb_customer(id)
);
create index idx_address_customer_id on tb_address(customer_id);

create table tb_customer_group (
     id bigint not null auto_increment,
     name varchar(50) not null,
     created_by varchar(50),
     created_at datetime,
     updated_by varchar(50),
     updated_at datetime,
     primary key (id)
);

create table tb_customer_group_join (
     id bigint not null auto_increment,
     customer_id bigint not null,
     group_id bigint not null,
     created_by varchar(50),
     created_at datetime,
     updated_by varchar(50),
     updated_at datetime,
     primary key (id),
     unique key (customer_id, group_id),
     foreign key (customer_id) references tb_customer(id),
     foreign key (group_id) references tb_customer_group(id)
);

create table tb_facet (
     id bigint not null auto_increment,
     name varchar(50) not null,
     code varchar(50) not null,
     visible_to_public boolean,
     created_by varchar(50),
     created_at datetime,
     updated_by varchar(50),
     updated_at datetime,
     unique key (code),
     primary key (id)
);

create index idx_facet_code on tb_facet(code);

create table tb_facet_value (
     id bigint not null auto_increment,
     name varchar(50) not null,
     code varchar(50) not null,
     facet_id bigint not null,
     created_by varchar(50),
     created_at datetime,
     updated_by varchar(50),
     updated_at datetime,
     primary key (id),
     foreign key (facet_id) references tb_facet(id)
);

create index idx_facet_value_facet_id on tb_facet_value(facet_id);

create table asset (
    id bigint not null auto_increment,
    name varchar(100),
    type varchar(50),
    file_size integer,
    width integer,
    height integer,
    mime_type varchar(50),
    source varchar(255),
    preview varchar(255),
    created_by varchar(50),
    created_at datetime,
    updated_by varchar(50),
    updated_at datetime,
    primary key (id)
);

create table tb_session (
    id bigint not null auto_increment,
    token varchar(100) not null,
    expires datetime not null,
    invalidated boolean not null,
    anonymous boolean not null default false,
    user_id bigint,
    authentication_strategy varchar(50),
    active_order_id bigint,
    created_by varchar(50),
    created_at datetime,
    updated_by varchar(50),
    updated_at datetime,
    primary key (id),
    unique key (token),
    foreign key (user_id) references tb_user(id)
    /* foreign key (active_order_id) references to_order(id) */
);

create index idx_session_user_id on tb_session(user_id);
create index idx_session_token on tb_session(token);
create index idx_session_active_order_id on tb_session(active_order_id);

create table tb_customer_history_entry (
    id bigint not null auto_increment,
    administrator_id bigint,
    type varchar(50) not null,
    visible_to_public boolean,
    data text,
    customer_id bigint,
    created_by varchar(50),
    created_at datetime,
    updated_by varchar(50),
    updated_at datetime,
    primary key (id)
);

create index idx_customer_history_entry_type on tb_customer_history_entry(type);

create table tb_order_history_entry (
    id bigint not null auto_increment,
    administrator_id bigint,
    type varchar(50) not null,
    is_public boolean,
    data text,
    order_id bigint,
    created_by varchar(50),
    created_at datetime,
    updated_by varchar(50),
    updated_at datetime,
    primary key (id)
);

create table tb_product_option_group (
   id bigint not null auto_increment,
   name varchar(50) not null,
   code varchar(50) not null,
   product_id bigint,
   created_by varchar(30),
   created_at datetime,
   updated_by varchar(30),
   updated_at datetime,
   primary key (id)
/* foreign key (product_id) references tb_product(id) */
);

create table tb_product_option (
   id bigint not null auto_increment,
   name varchar(50) not null,
   code varchar(50) not null,
   group_id bigint not null,
   created_by varchar(50),
   created_at datetime,
   updated_by varchar(50),
   updated_at datetime,
   primary key (id),
   foreign key (group_id) references tb_product_option_group(id)
);