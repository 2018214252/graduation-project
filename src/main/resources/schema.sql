create table if not exists organization
(
    id bigint(19) not null primary key ,
    name varchar(45),
    type varchar(45),
    tel varchar(45),
    mp varchar(45),
    address varchar(45),
    preid bigint(19),
    state varchar(45),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists car
(
    id bigint(19) not null primary key,
    number varchar(45),
    type varchar(45),
    speed int(5),
    loading int(5),
    size varchar(45),
    date varchar(45),
    state varchar(45),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists agriculture
(
    id bigint(19) not null primary key,
    name varchar(45),
    type varchar(45),
    origin varchar(45),
    manufacturer varchar(45),
    processor varchar(45),
    processingtime varchar(45),
    effectivedate varchar(45),
    storage varchar(45),
    remark varchar(45),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists network
(
    id bigint(19) not null primary key,
    name varchar(45),
    type varchar(45),
    tel varchar(45),
    head varchar(45),
    mp varchar(45),
    address varchar(45),
    city varchar(45),
    state varchar(45),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
    );

create table if not exists warehouse
(
    id bigint(19) not null primary key,
    name varchar(45),
    tel varchar(45),
    head varchar(45),
    mp varchar(45),
    address varchar(45),
    city varchar(45),
    state varchar(45),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists inventory
(
    id bigint(19) not null primary key,
    name varchar(45),
    warehouse bigint(19),
    whname varchar(45),
    quantity int(5),
    price int(5),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
    );

create table if not exists inventory_records
(
    id bigint(19) not null primary key,
    type int(5),
    head varchar(45),
    name varchar(45),
    warehouse bigint(19),
    whname varchar(45),
    quantity int(5),
    date varchar(45),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists move_records
(
    id bigint(19) not null primary key,
    head varchar(45),
    original_warehouse varchar(45),
    target_warehouse varchar(45),
    date varchar(45),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);

create table if not exists orderr
(
    id bigint(19) not null primary key,
    customerNumber bigint(19),
    name varchar(45),
    pro_name varchar(45),
    quantity int,
    unit_price int,
    sum_price int,
    address varchar(45),
    phone varchar(45),
    state varchar(45),
    date varchar(45),
    feedback varchar(45),
    deliveryNumber bigint(19),
    remark varchar(45),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
    );

create table if not exists delivery(
    id bigint(19) not null primary key,
    oid varchar(45),
    msg varchar(45),
    date varchar(45)
)


