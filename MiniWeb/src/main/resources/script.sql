create table user
(
    uid      int auto_increment,
    username varchar(32)  not null,
    email    varchar(200) not null,
    password varchar(32)  not null,
    role     int          not null,
    constraint uid
        unique (uid),
    constraint username
        unique (username)
);

alter table user
    add primary key (uid);

create table task
(
    tid             int auto_increment
        primary key,
    customer_id     int      not null,
    driver_id       int      null,
    pickup_time     datetime not null,
    deliver_time    datetime not null,
    pickup_address  text     not null,
    deliver_address text     not null,
    remarks         text     null,
    contact_number  int      null,
    status          int      not null,
    post_time       datetime not null,
    constraint customer_id
        foreign key (customer_id) references user (uid)
            on update cascade on delete cascade
);

create table msg
(
    mid       int auto_increment
        primary key,
    talker    varchar(32) not null,
    listener  varchar(32) not null,
    message   text        not null,
    post_time datetime    not null,
    task_id   int         not null,
    constraint task_id
        foreign key (task_id) references task (tid)
            on update cascade on delete cascade
);


