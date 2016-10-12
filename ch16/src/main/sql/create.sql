create table t_account (
    id number(19, 0) not null,
    sort_code varchar2(6) not null,
    number_ varchar2(8) not null,
    balance number(19, 2) not null,
    constraint pk_account primary key (id)
)
/

