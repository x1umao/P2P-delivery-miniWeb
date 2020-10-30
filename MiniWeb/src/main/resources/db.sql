create database miniweb;
use miniweb;
select database();
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
    tid            int primary key auto_increment,
    customer_id    int       not null,
    driver_id      int       null,
    pickup_time    datetime  not null,
    deliver_time   datetime  not null,
    pickup_code    int(6)    not null,
    deliver_code   int(6)    not null,
    remarks        text      null,
    contact_number int       null,
    status         int       not null,
    post_time      timestamp not null,

    constraint customer_id
        foreign key (customer_id) references user (uid)
            on update cascade on delete cascade
);
