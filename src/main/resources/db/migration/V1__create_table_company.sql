create table company
(
    id   bigint unsigned auto_increment,
    name varchar(255) not null comment '企業名',
    constraint company_pk
        primary key (id)
) comment '企業情報';
