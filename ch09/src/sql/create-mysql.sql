create table t_customer (
    id int auto_increment not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    last_login timestamp null,
    comments text null,
    constraint pk_customer primary key(id)
);