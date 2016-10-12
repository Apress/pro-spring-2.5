create table t_log_entry (
    id number(19, 0) not null,
    name_ varchar2(50) not null,
    date_ timestamp not null,
    constraint pk_log_entry primary key (id)
)
/
create sequence s_log_entry_id start with 1000
/