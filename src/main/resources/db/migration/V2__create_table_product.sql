create table product
(
    id         bigint unsigned auto_increment,
    name       varchar(255) not null comment '製品名',
    company_id bigint unsigned not null comment '製造企業ID',
    constraint product_pk
        primary key (id),
    constraint product_company_id_fk
        foreign key (company_id) references company (id)
            on update cascade
) comment '製品情報';

